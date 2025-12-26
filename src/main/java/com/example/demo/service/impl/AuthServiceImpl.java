package com.example.demo.service.impl;

import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;

public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;

    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(String email, String password) {
        return jwtUtil.generateToken(email);
    }
}
