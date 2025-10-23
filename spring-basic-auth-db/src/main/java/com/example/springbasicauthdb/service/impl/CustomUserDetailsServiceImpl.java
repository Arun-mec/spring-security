package com.example.springbasicauthdb.service.impl;

import com.example.springbasicauthdb.enitty.User;
import com.example.springbasicauthdb.repository.UserRepository;
import com.example.springbasicauthdb.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User userInfo = userRepository.loadUserByUsername(username);
        if (userInfo == null)
            throw new UsernameNotFoundException("Username is not found!");
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .roles(String.valueOf(userInfo.getRole()))
                .build();
        return userDetails;
    }

}
