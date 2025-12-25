package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    // ✅ Constructor Injection (MANDATORY for tests)
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // =========================
    // LOGIN
    // =========================
    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto request) {
        return authService.login(request);
    }

    // =========================
    // REGISTER
    // =========================
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDto request) {
        authService.register(request);
    }
}
