package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Permission permission;

    private Timestamp grantedAt;

    @PrePersist
    public void onGrant() {
        grantedAt = new Timestamp(System.currentTimeMillis());
    }

    // getters & setters
}
