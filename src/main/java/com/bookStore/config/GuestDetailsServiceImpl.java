package com.bookStore.config;

import com.bookStore.model.GuestDtls;
import com.bookStore.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GuestDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private GuestRepository guestRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        GuestDtls guest= guestRepo.findUserByEmail(email);
        if(guest!=null){
            return new CustomGuestDetails(guest);
        }
        throw new UsernameNotFoundException("user not avaliable");
    }
}
