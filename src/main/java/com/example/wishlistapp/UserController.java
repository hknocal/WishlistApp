package com.example.wishlistapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String userList(Model model) {
        List<User> userList = userService.getUsers();
        model.addAttribute("users", userList);
        return "user-list";
    }

    @GetMapping("/create-user")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping("/create-user")
    public String saveUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        userService.createUser(user);
        return "user-success";
    }


}
