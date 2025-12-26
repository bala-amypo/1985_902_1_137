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

    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    // ================= CREATE =================
    @Override
    public UserAccount createUser(UserAccount user) {
        if (userAccountRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        user.setActive(true);
        return userAccountRepository.save(user);
    }

    // ================= UPDATE =================
    @Override
    public UserAccount updateUser(Long id, UserAccount user) {
        UserAccount existing = userAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        existing.setEmail(user.getEmail());
        existing.setFullName(user.getFullName());

        return userAccountRepository.save(existing);
    }

    // ================= GET BY ID =================
    @Override
    public UserAccount getUser(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    // ================= DEACTIVATE =================
    @Override
    public void deactivateUser(Long id) {
        UserAccount user = userAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setActive(false);
        userAccountRepository.save(user);
    }

    // ================= GET ALL =================
    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }
}
