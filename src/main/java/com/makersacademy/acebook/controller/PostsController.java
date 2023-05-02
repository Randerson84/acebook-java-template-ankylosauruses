package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.PostRepository;
import com.makersacademy.acebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class PostsController {

    @Autowired
    PostRepository repository;

    @Autowired
    UserRepository userRepo;

    @GetMapping("/posts")
    public String index(Model model, @CookieValue("cuid") String uid) {
        Iterable<Post> posts = repository.findAll();
        List<Post> reverseOrderPost = StreamSupport.stream(posts.spliterator(), false)
                .sorted(Comparator.comparing(Post::getId).reversed())
                .collect(Collectors.toList());
        model.addAttribute("posts", reverseOrderPost);
        model.addAttribute("post", new Post());
        User user = User.findUser(uid, userRepo);
//        for (User u: userRepo.findAll()){if (u.getUsername().equals(uid)){user = u;break;}}
        model.addAttribute("user", "/users/"+user.getId());
        return "posts/index";
    }

    @PostMapping("/posts")
    public RedirectView create(@ModelAttribute Post post, @CookieValue("cuid") String uid) {
        User user = new User();
        for (User u: userRepo.findAll()){if (u.getUsername().equals(uid)){user = u;break;}}
        post.setUID(user.getId());
        post.setLikes(0);
        repository.save(post);
        return new RedirectView("/posts");
    }
    @PostMapping("/posts/{id}/likes")
    public RedirectView increment(@PathVariable("id") Long id) {
        Post post = repository.findById(id).get();
        Integer likes = post.getLikes();
        post.setLikes(likes+1);
        repository.save(post);
        return new RedirectView("/posts");
    }
}
