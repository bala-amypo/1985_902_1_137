package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role createRole(Role role) {
        return repository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        role.setId(id);
        return repository.save(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public void deactivateRole(Long id) {
        Role role = repository.findById(id).orElseThrow();
        role.setActive(false);
        repository.save(role);
    }
}
