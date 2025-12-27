package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    // =========================
    // CREATE USER
    // =========================
    @Override
    public UserAccount createUser(UserAccount user) {

        // ✅ t12_createUser_duplicateEmail
        if (repository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        return repository.save(user);
    }

    // =========================
    // UPDATE USER
    // =========================
    @Override
    public UserAccount updateUser(Long id, UserAccount user) {

        // ✅ t14_updateUser_notFound
        UserAccount existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        existing.setEmail(user.getEmail());
        existing.setFullName(user.getFullName());
        existing.setPassword(user.getPassword());
        existing.setActive(user.isActive());

        return repository.save(existing);
    }

    // =========================
    // GET USER BY ID
    // =========================
    @Override
    public UserAccount getUserById(Long id) {

        // ✅ t16_getUserById_notFound
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    // =========================
    // DELETE USER
    // =========================
    @Override
    public void deleteUser(Long id) {
        getUserById(id);
        repository.deleteById(id);
    }

    // =========================
    // AUTH: REGISTER
    // =========================
    @Override
    public UserAccount register(UserAccount user) {

        if (repository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        return repository.save(user);
    }

    // =========================
    // AUTH: LOGIN
    // =========================
    @Override
    public UserAccount login(String email, String password) {

        UserAccount user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new BadRequestException("Invalid credentials");
        }

        return user;
    }

    // =========================
    // GET ALL USERS
    // =========================
    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    // =========================
    // DEACTIVATE USER
    // =========================
    @Override
    public void deactivateUser(Long id) {
        UserAccount user = getUserById(id);
        user.setActive(false);
        repository.save(user);
    }
}
