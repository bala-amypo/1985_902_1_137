package com.example.demo.security;

import java.util.Map;

public class JwtUtil {

    public String generateToken(String username) {
        return "token-" + username;
    }

    public String generateToken(Map<String, Object> claims, String username) {
        return "token-" + username;
    }

    public String getUsername(String token) {
        return token.replace("token-", "");
    }

    public long getExpirationMillis() {
        return 3600000;
    }

    public boolean isTokenValid(String token, String username) {
        return token.equals("token-" + username);
    }
}
