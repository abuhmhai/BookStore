package com.bookStore.service;

import com.bookStore.model.UserDtls;
import com.bookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDtls createUser(UserDtls user) {
        return userRepo.save(user);
    }
    @Override
    public boolean checkEmail(String email) {
        return userRepo.existsUserByEmail(email);
    }
}
