package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userAccountService.createUser(user);
    }

    @PutMapping("/{id}")
    public UserAccount updateUser(
            @PathVariable Long id,
            @RequestBody UserAccount user) {
        return userAccountService.updateUser(id, user);
    }

    // 🔧 FIXED HERE
    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return userAccountService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deactivateUser(@PathVariable Long id) {
        userAccountService.deactivateUser(id);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }
}
