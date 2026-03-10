package com.sena.test.service.impl;

import org.springframework.stereotype.Service;
import com.sena.test.entity.user;
import com.sena.test.repository.IUserRepository;
import com.sena.test.service.IuserService;
import java.util.List;

public class userService {

    private IUserRepository userRepository;
    
    public List<user> findAllUser() {
        return userRepository.findAll();
    }

    public user saveUser(user user) {
        return userRepository.save(user);
    }
}
