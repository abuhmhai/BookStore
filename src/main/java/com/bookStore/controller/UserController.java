package com.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public String home() {
        return "user/user_home";
    }

    @GetMapping("/book")
    public String book() {
        return "user/user_bookList";
    }

    @GetMapping("/mybooks")
    public String mybooks() {
        return "user/user_myBooks";
    }
}