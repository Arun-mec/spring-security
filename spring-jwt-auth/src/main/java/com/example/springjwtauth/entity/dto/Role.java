package com.example.springjwtauth.entity.dto;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
public enum Role {

    USER(Set.of(Permission.STATE_READ)),
    ADMIN(Set.of(Permission.STATE_READ, Permission.STATE_WRITE, Permission.STATE_DELETE));

    Set<Permission> permissions = new HashSet<>();

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}