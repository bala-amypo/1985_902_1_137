package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/permissions")
@Tag(name = "permission-controller")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    @Operation(summary = "Create permission")
    public Permission create(@RequestBody Permission permission) {
        return permissionService.createPermission(permission);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get permission by ID")
    public Permission getById(@PathVariable Long id) {
        return permissionService.getPermissionById(id);
    }

    @GetMapping
    @Operation(summary = "Get all permissions")
    public List<Permission> getAll() {
        return permissionService.getAllPermissions();
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate permission")
    public void deactivate(@PathVariable Long id) {
        permissionService.deactivatePermission(id);
    }
}
