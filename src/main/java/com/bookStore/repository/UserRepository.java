package com.bookStore.repository;

import com.bookStore.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
    boolean existsUserByEmail(String email);
}