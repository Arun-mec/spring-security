package com.example.springjwtauth.entity.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class AuthRequest {
    private String username;
    private String password;
}
