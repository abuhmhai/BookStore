package com.bookStore.service;

import com.bookStore.model.GuestDtls;
import com.bookStore.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestRepository guestRepo;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public GuestDtls createGuest(GuestDtls guest) {

        guest.setPassword(passwordEncoder.encode(guest.getPassword()));
        guest.setRole("ROLE_GUEST");
        return guestRepo.save(guest);
    }
    @Override
    public boolean checkEmail(String email) {
        return guestRepo.existsUserByEmail(email);
    }
}
