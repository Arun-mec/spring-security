package com.example.springjwtauth.service;

import com.example.springjwtauth.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User createUser(User user);
}
