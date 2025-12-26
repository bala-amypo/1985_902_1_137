package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Permission {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Permission() {}

    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }
}
