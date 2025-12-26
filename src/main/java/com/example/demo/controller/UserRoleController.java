package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/user-roles")
@Tag(name = "user-role-controller")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    @Operation(summary = "Assign role to user")
    public UserRole create(@RequestBody UserRole userRole) {
        return userRoleService.assignRole(userRole);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user-role by ID")
    public UserRole getById(@PathVariable Long id) {
        return userRoleService.getById(id);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get roles for user")
    public List<UserRole> getByUser(@PathVariable Long userId) {
        return userRoleService.getRolesForUser(userId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove role from user")
    public void delete(@PathVariable Long id) {
        userRoleService.removeRole(id);
    }
}
