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
@Tag(name = "Permission Controller")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    // ================= GET =================
    @GetMapping
    @Operation(
        summary = "Get all permissions",
        description = "Fetch all active permissions"
    )
    public List<Permission> getAllPermissions(
        @Parameter(
            description = "Filter by active status",
            example = "true"
        )
        @RequestParam(required = false) Boolean active
    ) {
        return permissionService.getAllPermissions();
    }

    // ================= POST =================
    @PostMapping
    @Operation(
        summary = "Create permission",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            description = "Permission object",
            content = @Content(
                schema = @Schema(implementation = Permission.class)
            )
        )
    )
    public Permission createPermission(
        @RequestBody Permission permission
    ) {
        return permissionService.createPermission(permission);
    }
}
