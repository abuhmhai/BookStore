package com.bookStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest/")
public class GuestController {

    @GetMapping("/")
    public String  home()
    {
        return "guest/home";
    }
}
