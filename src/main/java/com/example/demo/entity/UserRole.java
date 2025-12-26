package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime assignedAt;

    public void setId(long id) { this.id = id; }

    public void prePersist() {
        this.assignedAt = LocalDateTime.now();
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }
}
