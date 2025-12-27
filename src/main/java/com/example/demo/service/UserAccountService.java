package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    // EXISTING METHODS (DO NOT TOUCH)
    UserAccount createUser(UserAccount user);
    UserAccount updateUser(Long id, UserAccount user);
    UserAccount getUserById(Long id);
    void deleteUser(Long id);

    // ✅ ADD THESE (NEW – SAFE)
    UserAccount register(UserAccount user);
    UserAccount login(String email, String password);
}
