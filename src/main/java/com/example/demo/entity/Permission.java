package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Permission {

    @Id
    @GeneratedValue
    private Long id;

    private String permissionKey;
    private String description;
    private boolean active = true;

    public Permission() {}

    public Long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getPermissionKey() { return permissionKey; }
    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
