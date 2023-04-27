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
        //separate posts/friends lists in to their own methods
        //create user list and populate
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        //create new user and populate by ID
        User user = new User();
        for (User e :users) {
                if (Long.toString(e.getId()).equals(id)){user = e;}}
        //add attributes
        model.addAttribute("username", id);
        model.addAttribute("user", user);
        //find all posts
        Iterable<Post> posts = repository.findAll();
        //create list of user posts and populate
        ArrayList<Post> userPosts = new ArrayList<>();
        for (Post post : posts){if (post.getUser_id().toString().equals(id)){userPosts.add(post);}}
        //create friends arraylist of users
        ArrayList<User> friendsList = new ArrayList<>();
        //convert String friends list from user obj to list
        String[] friends = null;
        if(user.getFriendsList() != null){friends = user.getFriendsList().split(",");
            //for all users if their id is within friends list add them to friends array list
            for (User u : userRepository.findAll()){if (Arrays.asList(friends).contains(u.getId().toString())){friendsList.add(u);}}}
        //add friends list and posts attributes
        model.addAttribute("friendsList", friendsList);
        model.addAttribute("posts", userPosts);
        model.addAttribute("profileString", user.getProfile_picture());
        return "users/profile";
    }
}
