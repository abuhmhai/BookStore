package com.bookStore.controller;

import com.bookStore.model.UserDtls;
import com.bookStore.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String register()
    {
        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDtls user, HttpSession session)
    {
        //System.out.println(user);

        boolean f=userService.checkEmail(user.getEmail());
        if(f)
        {
            session.setAttribute("msg", "Email Id already exist");
        }
        else {
            UserDtls userDtls =userService.createUser(user);
            if(userDtls!=null)
            {
                session.setAttribute("msg", "Registration Successful");
            }
            else{
                session.setAttribute("msg", "Something went wrong");

            }
        }

        return "redirect:/register";
    }

}
