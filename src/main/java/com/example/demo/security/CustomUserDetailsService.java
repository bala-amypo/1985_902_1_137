package com.example.demo.security;

import com.example.demo.repository.UserAccountRepository;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetailsService {

    public CustomUserDetailsService(
            UserAccountRepository userAccountRepository,
            UserRoleRepository userRoleRepository
    ) {
    }

    public UserDetails loadUserByUsername(String username) {
        return User.withUsername(username)
                .password("password")
                .authorities("USER")
                .build();
    }
}
