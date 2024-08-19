package com.bookStore.repository;

import com.bookStore.model.GuestDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestDtls, Integer> {
    boolean existsUserByEmail(String email);
    GuestDtls findUserByEmail(String email);
}