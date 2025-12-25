package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "test_secret_key";
    private final long EXPIRATION_MILLIS = 60 * 60 * 1000; // 1 hour

    // ✅ NO-ARG constructor REQUIRED by tests
    public JwtUtil() {
    }

    // =========================
    // Generate JWT Token
    // =========================
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // =========================
    // Extract username
    // =========================
    public String getUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // =========================
    // Expiration getter (TEST 51)
    // =========================
    public long getExpirationMillis() {
        return EXPIRATION_MILLIS;
    }

    // =========================
    // Validate token (TEST 52, 53)
    // =========================
    public boolean isTokenValid(String token, String username) {
        return getUsername(token).equals(username);
    }

    // =========================
    // Internal helper
    // =========================
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
