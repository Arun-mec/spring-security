package com.example.springjwtauth.controller;

import com.example.springjwtauth.entity.dto.AuthRequest;
import com.example.springjwtauth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping
    public String loginUser(@RequestBody AuthRequest authRequest) {
        UserDetails userDetails = authService.authenticateUser(
                authRequest.getUsername(), authRequest.getPassword());
        return authService.generateToken(userDetails);
    }

}
