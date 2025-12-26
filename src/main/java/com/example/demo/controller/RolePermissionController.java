package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.RolePermission;
import com.example.demo.service.RolePermissionService;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/role-permissions")
@Tag(name = "role-permission-controller")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping
    @Operation(summary = "Assign permission to role")
    public RolePermission assign(@RequestBody RolePermission rolePermission) {
        return rolePermissionService.assignPermission(rolePermission);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get role-permission mapping by ID")
    public RolePermission getById(@PathVariable Long id) {
        return rolePermissionService.getMappingById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove role-permission mapping")
    public void remove(@PathVariable Long id) {
        rolePermissionService.removePermission(id);
    }

    @GetMapping("/role/{roleId}")
    @Operation(summary = "Get permissions for role")
    public List<RolePermission> getByRole(@PathVariable Long roleId) {
        return rolePermissionService.getPermissionsForRole(roleId);
    }
}
