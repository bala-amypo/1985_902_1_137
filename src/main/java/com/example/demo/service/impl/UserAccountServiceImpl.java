package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
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

        // ✅ FIX: duplicate email check (t12)
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        return repository.save(user);
    }

    // =========================
    // UPDATE USER
    // =========================
    @Override
    public UserAccount updateUser(Long id, UserAccount user) {

        // ✅ FIX: throws if not found (t14)
        UserAccount existing = getUserById(id);

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

        // ✅ FIX: throws if not found (t16)
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // =========================
    // DELETE USER
    // =========================
    @Override
    public void deleteUser(Long id) {

        // ensure not-found throws
        getUserById(id);
        repository.deleteById(id);
    }

    // =========================
    // AUTH: REGISTER
    // =========================
    @Override
    public UserAccount register(UserAccount user) {

        // reuse duplicate email logic
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        return repository.save(user);
    }

    // =========================
    // AUTH: LOGIN
    // =========================
    @Override
    public UserAccount login(String email, String password) {

        // safer than email+password query
        UserAccount user = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
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
