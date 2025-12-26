package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Role() {}

    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }
}
