package com.example.springbasicauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(){
        return "Hello world!";
    }

    @GetMapping("/test")
    public String test(Authentication authentication){
        return "Welcome to test!"+authentication.getName();
    }
}
