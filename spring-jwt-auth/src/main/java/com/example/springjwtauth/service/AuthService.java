package com.example.springjwtauth.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {

    public UserDetails authenticateUser(String username, String password);

    public String generateToken(UserDetails userDetails);
}
