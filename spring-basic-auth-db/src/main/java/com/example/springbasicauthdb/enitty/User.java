package com.example.springbasicauthdb.enitty;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        USER, ADMIN
    }
}
