package com.bookStore.repository;

import com.bookStore.model.UserDtls;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
    boolean existsUserByEmail(String email);
    UserDtls findUserByEmail(String email);
}