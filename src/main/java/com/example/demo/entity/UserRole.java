package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserAccount user;

    @ManyToOne
    private Role role;

    private LocalDateTime assignedAt;

    public UserRole() {}

    public Long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public UserAccount getUser() { return user; }
    public void setUser(UserAccount user) { this.user = user; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public void prePersist() {
        this.assignedAt = LocalDateTime.now();
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }
}
