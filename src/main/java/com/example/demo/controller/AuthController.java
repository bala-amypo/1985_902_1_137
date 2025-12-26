package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "auth-controller", description = "Authentication APIs")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ================= LOGIN =================

    @Operation(
            summary = "User Login",
            description = "Authenticate user and return JWT token"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Login successful",
            content = @Content(schema = @Schema(implementation = AuthResponseDto.class))
    )
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(
            @RequestBody(
                    description = "Login credentials",
                    required = true,
                    content = @Content(schema = @Schema(implementation = AuthRequestDto.class))
            )
            @org.springframework.web.bind.annotation.RequestBody AuthRequestDto request
    ) {
        return ResponseEntity.ok(authService.login(request));
    }

    // ================= REGISTER =================

    @Operation(
            summary = "User Registration",
            description = "Register a new user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "User registered successfully"
    )
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody(
                    description = "Registration details",
                    required = true,
                    content = @Content(schema = @Schema(implementation = RegisterRequestDto.class))
            )
            @org.springframework.web.bind.annotation.RequestBody RegisterRequestDto request
    ) {
        authService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }
}
