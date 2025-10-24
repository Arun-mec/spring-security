package com.example.springjwtauth.service.impl;

import com.example.springjwtauth.service.AuthService;
import com.example.springjwtauth.service.CustomUserDetailsService;
import com.example.springjwtauth.util.JwtUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailsService userService;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public UserDetails authenticateUser(String username, String password) {
        try {
            Authentication userAuthentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                    username, password)
            );
            return (UserDetails) userAuthentication.getPrincipal();
        }
        catch (Exception ex) {
            throw new BadCredentialsException("Username/password should not be empty!"+ex);
        }
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+jwtUtil.getExpiration()))
                .signWith(jwtUtil.getSecretKey())
                .compact();
    }
}
