package com.bookStore.controller;

import com.bookStore.model.UserDtls;
import com.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String home()
    {
        return "home";
    }
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDtls());
        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDtls user, HttpSession session) {
        boolean emailExists = userService.checkEmail(user.getEmail());

        if (emailExists) {
            session.setAttribute("msg", "Email Id already exists");
        } else {
            UserDtls newUser = userService.createUser(user);
            if (newUser != null && newUser.getId() > 0) { // Check if the ID is a positive number
                session.setAttribute("msg", "Registration Successful");
            } else {
                session.setAttribute("msg", "Something went wrong during registration");
            }
        }

        return "redirect:/register";
    }

}
