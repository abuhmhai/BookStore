package com.bookStore.controller;

import com.bookStore.model.GuestDtls;
import com.bookStore.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestRepository guestRepo;

    @ModelAttribute
    private void modelAttribute(Model m, Principal p) {
        String email = p.getName();
        GuestDtls guest = guestRepo.findUserByEmail(email);

        m.addAttribute("guest", guest);
    }

    @GetMapping("/")
    public String home() {
        return "guest/home";
    }
}