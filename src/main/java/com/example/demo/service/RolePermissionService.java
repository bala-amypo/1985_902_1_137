package com.example.demo.service;

import com.example.demo.entity.RolePermission;
import java.util.List;

public interface RolePermissionService {
    RolePermission grant(RolePermission rolePermission);
    List<RolePermission> getAll();
}
