package com.example.wishlistapp.controllers;

import com.example.wishlistapp.services.UserService;
import com.example.wishlistapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/user-list")
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
        return "user-creation-success";
    }

    @GetMapping("/edit-user")
    public String editUser(@RequestParam("id") int id, Model model) {
        User user = userService.getUserByID(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit-user")
    public String saveUserEdit (@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        userService.editUser(user);
        return "edit-user-success";
    }

    @GetMapping("/delete-user")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
