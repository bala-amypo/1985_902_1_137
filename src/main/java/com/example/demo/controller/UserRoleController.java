package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/user-roles")
@Tag(name = "user-role-controller", description = "User Role APIs")
public class UserRoleController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    @Operation(summary = "Assign role to user")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        required = true,
        content = @Content(schema = @Schema(implementation = UserRole.class))
    )
    public UserRole assignRole(@RequestBody UserRole userRole) {
        return userRoleService.assignRole(userRole);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user-role mapping by ID")
    public UserRole getMapping(@PathVariable Long id) {
        return userRoleService.getMappingById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove role from user")
    public void removeRole(@PathVariable Long id) {
        userRoleService.removeRole(id);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get roles for a user")
    public List<UserRole> getRolesForUser(@PathVariable Long userId) {
        return userRoleService.getRolesForUser(userId);
    }
}
