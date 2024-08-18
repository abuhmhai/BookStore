package com.bookStore.controller;

import com.bookStore.model.UserDtls;
import com.bookStore.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;
    @ModelAttribute
    private  void modelAttribute(Model m, Principal p) {
        String email = p.getName();
        UserDtls user= userRepo.findUserByEmail(email);

        m.addAttribute("user",user);
    }

    @GetMapping("/")
    public String home(){
        return "user/home";
    }
}
