package com.example.springjwtauth.entity.dto;

import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public enum Permission {
    STATE_READ,
    STATE_WRITE,
    STATE_DELETE
}
