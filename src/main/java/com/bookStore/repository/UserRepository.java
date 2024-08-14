package com.bookStore.repository;

import com.bookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method to find a user by username
    User findByUsername(String username);
}