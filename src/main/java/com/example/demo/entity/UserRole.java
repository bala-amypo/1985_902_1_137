package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserAccount user;

    @ManyToOne
    private Role role;

    private Instant assignedAt;

    @PrePersist
    public void prePersist() {
        this.assignedAt = Instant.now();
    }

    // getters & setters
}
