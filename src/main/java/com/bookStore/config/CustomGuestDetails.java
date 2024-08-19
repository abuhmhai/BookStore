package com.bookStore.config;

import com.bookStore.model.GuestDtls;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails; // Corrected to GuestDetails
import java.util.Arrays;
import java.util.Collection;

public class CustomGuestDetails implements UserDetails { // Corrected to GuestDetails

    private GuestDtls guest;

    public CustomGuestDetails(GuestDtls guest) {
        super();
        this.guest = guest;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(guest.getRole()); // Changed user to guest
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return guest.getPassword(); // Changed user to guest
    }

    @Override
    public String getUsername() {
        return guest.getEmail(); // Changed user to guest
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}