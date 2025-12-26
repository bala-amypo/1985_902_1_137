package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    // Create user
    UserAccount createUser(UserAccount user);

    // Update user by ID
    UserAccount updateUser(Long id, UserAccount user);

    // Get user by ID (must THROW exception if not found)
    UserAccount getUser(Long id);

    // Deactivate user
    void deactivateUser(Long id);

    // Get all users
    List<UserAccount> getAllUsers();
}
