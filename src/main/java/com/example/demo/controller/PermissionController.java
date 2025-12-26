package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/permissions")
@Tag(name = "permission-controller")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    @Operation(summary = "Get all permissions")
    public List<Permission> getAll() {
        return permissionService.getAllPermissions();
    }

    @PostMapping
    @Operation(
        summary = "Create permission",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(schema = @Schema(implementation = Permission.class))
        )
    )
    public Permission create(@RequestBody Permission permission) {
        return permissionService.createPermission(permission);
    }

    @PutMapping("/{id}/deactivate")
    @Operation(
        summary = "Deactivate permission",
        parameters = @Parameter(name = "id", required = true)
    )
    public void deactivate(@PathVariable Long id) {
        permissionService.deactivatePermission(id);
    }
}
