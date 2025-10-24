package com.example.springjwtauth.service.impl;

import com.example.springjwtauth.entity.User;
import com.example.springjwtauth.repository.UserRepository;
import com.example.springjwtauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        if (user.getUsername().isEmpty() || user.getUsername().isBlank())
            throw new IllegalArgumentException("Username should not be empty!");

        user.setRole(User.Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
