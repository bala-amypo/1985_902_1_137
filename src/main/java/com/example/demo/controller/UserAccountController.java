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

    // GET all users
    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }

    // GET user by id (PARAMETER SHOWN IN SWAGGER AUTOMATICALLY)
    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return userAccountService.getUserById(id);
    }

    // POST create user (BODY PARAMETER)
    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userAccountService.createUser(user);
    }

    // PUT update user (PATH + BODY PARAMETER)
    @PutMapping("/{id}")
    public UserAccount updateUser(
            @PathVariable Long id,
            @RequestBody UserAccount user) {
        return userAccountService.updateUser(id, user);
    }

    // DELETE deactivate user
    @DeleteMapping("/{id}")
    public void deactivateUser(@PathVariable Long id) {
        userAccountService.deactivateUser(id);
    }
}
