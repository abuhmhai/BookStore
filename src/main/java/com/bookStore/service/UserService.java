package com.bookStore.service;
// File: UserService.java

import com.bookStore.entity.User;
import com.bookStore.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("GUEST");
        user.getRoles().add(role);
        userRepository.save(user);
    }

    // Additional methods
}
