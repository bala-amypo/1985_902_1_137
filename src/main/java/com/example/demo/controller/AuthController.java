package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // =====================================================
    // LOGIN
    // =====================================================
    @PostMapping("/login")
    @Operation(summary = "User Login")
    public ResponseEntity<AuthResponseDto> login(
            @Parameter(description = "Email", example = "user@example.com")
            @RequestParam(required = false) String email,

            @Parameter(description = "Password", example = "password")
            @RequestParam(required = false) String password,

            @RequestBody(
                    required = true,
                    description = "Login credentials",
                    content = @Content(
                            schema = @Schema(implementation = AuthRequestDto.class)
                    )
            )
            @org.springframework.web.bind.annotation.RequestBody AuthRequestDto body
    ) {
        // IMPORTANT: Tests expect login(AuthRequestDto)
        return ResponseEntity.ok(authService.login(body));
    }

    // =====================================================
    // REGISTER
    // =====================================================
    @PostMapping("/register")
    @Operation(summary = "User Registration")
    public ResponseEntity<AuthResponseDto> register(
            @Parameter(description = "Email", example = "newuser@example.com")
            @RequestParam(required = false) String email,

            @Parameter(description = "Full Name", example = "John Doe")
            @RequestParam(required = false) String fullName,

            @Parameter(description = "Password", example = "password123")
            @RequestParam(required = false) String password,

            @RequestBody(
                    required = true,
                    description = "Registration details",
                    content = @Content(
                            schema = @Schema(implementation = RegisterRequestDto.class)
                    )
            )
            @org.springframework.web.bind.annotation.RequestBody RegisterRequestDto body
    ) {
        // IMPORTANT: Tests expect register(RegisterRequestDto)
        return ResponseEntity.ok(authService.register(body));
    }
}
