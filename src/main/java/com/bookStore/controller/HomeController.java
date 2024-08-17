package com.bookStore.controller;

import com.bookStore.model.UserDtls;
import com.bookStore.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String register()
    {
        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute User user)
    {
        //System.out.println(user);
        UserDtls userDtls =userService.createUser(user);
        if(userDtls!=null)
        {
            System.out.println("Register Successfully");
        }
        else{
            System.out.println("Someting went wrong");

        }
        return "redirect:/register";
    }

}
