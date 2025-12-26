package com.example.demo.security;

public class CustomUserDetailsService {

    public String loadUserByUsername(String username) {
        return username;
    }
}
