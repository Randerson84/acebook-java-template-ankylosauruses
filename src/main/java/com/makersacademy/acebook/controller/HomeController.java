package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HomeController {
	@RequestMapping(value = "/")
	public RedirectView index() {
		return new RedirectView("/homepage"); }

/*	public RedirectView index() {
		return new RedirectView("/posts");
	} */
	@Autowired
	UserRepository userRepo;

	@RequestMapping("/homepage")
	public String home() {
		return "homepage.html";
	}
	@RequestMapping(value = "/posts")
	public String posts() {
		return "index.html";
	}
	@RequestMapping("/login")
	public String login() {
		return "login.html";
	}
	@RequestMapping("/logout")
	public String logout(Model model, @CookieValue("cuid") String uid){
		User user = User.findUser(uid, userRepo);
//        for (User u: userRepo.findAll()){if (u.getUsername().equals(uid)){user = u;break;}}
        model.addAttribute("user", "/users/"+user.getId());
			return "logout.html";
		}

	// Login form with error
	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login.html";
	}

}
