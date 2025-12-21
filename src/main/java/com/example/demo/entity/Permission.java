package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "permissions", uniqueConstraints = @UniqueConstraint(columnNames = "permissionKey"))
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String permissionKey;
    private String description;
    private Boolean active = true;

    // getters & setters
}
