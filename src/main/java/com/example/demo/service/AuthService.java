import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;

public interface AuthService {
    package com.example.demo.service;

public interface AuthService {
    String login(String email, String password);
}


    String login(String email, String password);

    default String login(AuthRequestDto dto) {
        return login(dto.getEmail(), dto.getPassword());
    }

    default String register(RegisterRequestDto dto) {
        return "REGISTERED";
    }
}

