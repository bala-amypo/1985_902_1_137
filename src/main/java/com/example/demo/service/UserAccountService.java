package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    Optional<UserAccount> getUser(Long id);

    UserAccount getUserById(Long id);          // 🔴 REQUIRED

    UserAccount updateUser(Long id, UserAccount user); // 🔴 REQUIRED

    void deactivateUser(Long id);              // 🔴 REQUIRED

    List<UserAccount> getAllUsers();
}
