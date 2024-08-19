package com.bookStore.controller;

import com.bookStore.model.GuestDtls;
import com.bookStore.service.GuestService;
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
    private GuestService guestService;
    @GetMapping("/")
    public String home()
    {
        return "index";
    }
    @GetMapping("/signin")
    public String login()
    {
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("guest", new GuestDtls());
        return "register";
    }

    @PostMapping("/createGuest")
    public String createguest(@ModelAttribute GuestDtls guest, HttpSession session) {
        boolean emailExists = guestService.checkEmail(guest.getEmail());

        if (emailExists) {
            session.setAttribute("msg", "Email Id already exists");
        } else {
            GuestDtls newGuest = guestService.createGuest(guest);
            if (newGuest != null && newGuest.getId() > 0) { // Check if the ID is a positive number
                session.setAttribute("msg", "Registration Successful");
            } else {
                session.setAttribute("msg", "Something went wrong during registration");
            }
        }

        return "redirect:/register";
    }

}
