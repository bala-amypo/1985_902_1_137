package com.example.demo.security;

public class JwtUtil {

    public String generateToken(String username) {
        return "dummy-token-for-" + username;
    }

    public String extractUsername(String token) {
        return token.replace("dummy-token-for-", "");
    }
}
