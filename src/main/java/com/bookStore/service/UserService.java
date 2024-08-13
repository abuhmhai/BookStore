package com.bookStore.service;

import com.bookStore.entity.User;
import com.bookStore.entity.Role;  // Correct import for Role entity
import com.bookStore.repository.RoleRepository;
import com.bookStore.repository.UserRepository;
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

        // Fetching the "GUEST" role from the database
        Role role = roleRepository.findByName("GUEST");

        // Adding the role to the user's roles set
        user.getRoles().add(role);

        // Saving the user in the database
        userRepository.save(user);
    }

    // Additional methods (like findByUsername, etc.)
}
