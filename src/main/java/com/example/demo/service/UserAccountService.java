package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    // EXISTING
    UserAccount createUser(UserAccount user);
    UserAccount updateUser(Long id, UserAccount user);
    UserAccount getUserById(Long id);
    void deleteUser(Long id);

    // AUTH
    UserAccount register(UserAccount user);
    UserAccount login(String email, String password);

    // ✅ ADD THESE (REQUIRED BY CONTROLLER)
    List<UserAccount> getAllUsers();
    void deactivateUser(Long id);
}
