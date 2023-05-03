package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Comment;
import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.repository.CommentRepository;
import com.makersacademy.acebook.repository.UserRepository;
import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CommentController {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @PostMapping("/comments/{id}")
    public RedirectView create(@ModelAttribute Comment comment, Authentication auth, @PathVariable("id") Long id) {
        String username = auth.getName() ;
        Long userId = userRepository.findByUsername(username).get(0).getId();
        comment.setUsersid(userId);
//        Post post = postRepository.findById(id).get();
     comment.setPostsid(id);
        commentRepository.save(comment);
        return new RedirectView("/posts");
    }
}