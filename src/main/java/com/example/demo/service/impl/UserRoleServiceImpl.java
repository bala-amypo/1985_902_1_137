package com.example.demo.service.impl;

import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository repo;

    public UserRoleServiceImpl(UserRoleRepository repo) {
        this.repo = repo;
    }

    public UserRole assign(UserRole userRole) {
        return repo.save(userRole);
    }

    public List<UserRole> getAll() {
        return repo.findAll();
    }
}
