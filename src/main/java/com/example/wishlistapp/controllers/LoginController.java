package com.example.wishlistapp.controllers;


import com.example.wishlistapp.models.User;
import com.example.wishlistapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("user") User user, Model model) {
        User foundUser = userService.getUserByEmail(user.getEmail());
        model.addAttribute("user", foundUser);
        return "user";
    }
}
