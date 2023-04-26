package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Authority;
import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.AuthoritiesRepository;
import com.makersacademy.acebook.repository.PostRepository;
import com.makersacademy.acebook.repository.UserRepository;
import org.flywaydb.core.internal.util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class UsersController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Autowired
    PostRepository repository;
    private String id;

    @GetMapping("/users/new")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping("/users")
    public RedirectView signup(@ModelAttribute User user) {
        userRepository.save(user);
        Authority authority = new Authority(user.getUsername(), "ROLE_USER");
        authoritiesRepository.save(authority);
        return new RedirectView("/login");
    }

    @GetMapping("/users/{id}")
    public String profile(@PathVariable("id") String id, Model model) {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        User user = new User();
        for (User e :users) {if (user.getUsername() != null && user.getUsername().equals(id)){user = e;}}
        model.addAttribute("username", id);
        model.addAttribute("user", user);
        Iterable<Post> posts = repository.findAll();
        ArrayList<Post> userPosts = new ArrayList<>();
        for (Post post : posts){if (post.getUser_id() == Integer.valueOf(id)){userPosts.add(post);}}
        model.addAttribute("posts", userPosts);
        return "users/profile";
    }
}
