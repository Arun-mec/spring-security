package com.example.springbasicauthdb.service.impl;

import com.example.springbasicauthdb.enitty.User;
import com.example.springbasicauthdb.repository.UserRepository;
import com.example.springbasicauthdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        User currUser = userRepository.loadUserByUsername(user.getUsername());
        if (currUser!=null)
            throw new IllegalArgumentException("User already exists!");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.USER);
        return userRepository.save(user);
    }
}
