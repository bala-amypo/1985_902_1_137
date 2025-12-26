package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount updateUser(Long id, UserAccount user);

    UserAccount getUser(Long id);

    // ✅ REQUIRED FOR TEST CASES
    UserAccount getUserById(Long id);

    void deactivateUser(Long id);

    List<UserAccount> getAllUsers();
}
