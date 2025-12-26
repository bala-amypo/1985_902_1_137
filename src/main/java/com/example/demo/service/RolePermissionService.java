package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.RolePermission;

public interface RolePermissionService {

    // USED BY TESTS
    List<RolePermission> getPermissionsForRole(Long roleId);

    RolePermission getMappingById(Long id);

    // REQUIRED FOR CONTROLLER (ADD – does NOT break tests)
    RolePermission assignPermission(RolePermission rolePermission);

    void removePermission(Long id);
}
