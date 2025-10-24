package com.example.springjwtauth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import java.security.Key;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
@Getter
public class JwtUtil {

    private final String secretString = "my-secret-key-for-jwt-token-generation-with-256-characters";
    private final Key secretKey = Keys.hmacShaKeyFor(secretString.getBytes());
    private final int expiration = 1000*60*60;

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(secretKey)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean validateToken(String username, UserDetails userDetails, String token) {
        return Objects.equals(username, userDetails.getUsername()) &&!validateExpiry(token);
    }

    private boolean validateExpiry(String token) {
        return extractClaims(token).getExpiration().before(new Date(System.currentTimeMillis()));
    }
}
