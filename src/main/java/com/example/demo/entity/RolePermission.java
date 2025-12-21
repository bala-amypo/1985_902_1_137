package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Role role;

    @ManyToOne(optional = false)
    private Permission permission;

    private LocalDateTime grantedAt;

    @PrePersist
    public void prePersist() {
        grantedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public Permission getPermission() { return permission; }
    public void setPermission(Permission permission) { this.permission = permission; }
}
