package com.example.demo.service.impl;

import com.example.demo.entity.Permission;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;

    public PermissionServiceImpl(PermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Permission createPermission(Permission permission) {
        return repository.save(permission);
    }

    @Override
    public Permission updatePermission(Long id, Permission permission) {
        Permission existing = repository.findById(id).orElseThrow();

        existing.setPermissionKey(permission.getPermissionKey());
        existing.setDescription(permission.getDescription());
        existing.setActive(permission.isActive());

        return repository.save(existing);
    }

    @Override
    public Permission getPermissionById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Permission> getAllPermissions() {
        return repository.findAll();
    }

    @Override
    public void deactivatePermission(Long id) {
        Permission permission = repository.findById(id).orElseThrow();
        permission.setActive(false);
        repository.save(permission);
    }
}
