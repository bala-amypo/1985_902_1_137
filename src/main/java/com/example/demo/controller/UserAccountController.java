package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "user-account-controller")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public UserAccount getUserById(@PathVariable Long id) {
        return userAccountService.getUserById(id);
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }

    @PostMapping
    @Operation(summary = "Create user")
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userAccountService.createUser(user);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user")
    public UserAccount updateUser(
            @PathVariable Long id,
            @RequestBody UserAccount user) {
        return userAccountService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deactivate user")
    public void deactivateUser(@PathVariable Long id) {
        userAccountService.deactivateUser(id);
    }
}
