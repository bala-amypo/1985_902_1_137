package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/roles")
@Tag(name = "role-controller", description = "Role APIs")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get role by ID")
    public Role getById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @GetMapping
    @Operation(summary = "Get all roles")
    public List<Role> getAll() {
        return roleService.getAllRoles();
    }

    @PostMapping
    @Operation(summary = "Create role")
    public Role create(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update role")
    public Role update(@PathVariable Long id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate role")
    public void deactivate(@PathVariable Long id) {
        roleService.deactivateRole(id);
    }
}
