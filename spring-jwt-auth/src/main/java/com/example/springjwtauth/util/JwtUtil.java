package com.example.springjwtauth.util;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@Getter
public class JwtUtil {
    private final String secretString = "my-secret-key-for-jwt-token-generation-with-256-characters";
    private final Key secretKey = Keys.hmacShaKeyFor(secretString.getBytes());
    private final int expiration = 1000*60*60;
}
