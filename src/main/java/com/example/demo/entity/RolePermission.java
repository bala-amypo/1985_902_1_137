package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RolePermission {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime grantedAt;

    public void setId(long id) { this.id = id; }

    public void prePersist() {
        this.grantedAt = LocalDateTime.now();
    }

    public LocalDateTime getGrantedAt() {
        return grantedAt;
    }
}
