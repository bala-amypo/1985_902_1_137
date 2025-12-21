package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private UserAccount user;

    @ManyToOne(optional = false)
    private Role role;

    private LocalDateTime assignedAt;

    @PrePersist
    public void prePersist() {
        assignedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }

    public UserAccount getUser() { return user; }
    public void setUser(UserAccount user) { this.user = user; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
