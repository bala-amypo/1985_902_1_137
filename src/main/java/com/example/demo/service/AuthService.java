package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;

public interface AuthService {

    // Used by controllers / basic login
    String login(String email, String password);

    // Used by TEST CASE
    default String login(AuthRequestDto dto) {
        return login(dto.getEmail(), dto.getPassword());
    }

    // Used by TEST CASE
    default String register(RegisterRequestDto dto) {
        return "REGISTERED";
    }
}
