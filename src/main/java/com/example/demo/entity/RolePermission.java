package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Permission permission;

    private Instant grantedAt;

    @PrePersist
    public void prePersist() {
        this.grantedAt = Instant.now();
    }

    // getters & setters
}
