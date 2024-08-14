package com.bookStore.controller;

import com.bookStore.entity.User;
import com.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "signup"; // Returns the signup.html template
    }

    @PostMapping("/signup")
    public String processSignUp(@ModelAttribute User user) {
        userService.saveUser(user); // Save the user with the default role
        return "redirect:/login"; // Redirect to the login page after successful signup
    }
}