package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserAccount user;

    @ManyToOne
    private Role role;

    private Timestamp assignedAt;

    @PrePersist
    public void onAssign() {
        assignedAt = new Timestamp(System.currentTimeMillis());
    }

    // getters & setters
}
