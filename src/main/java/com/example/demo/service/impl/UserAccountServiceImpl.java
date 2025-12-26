package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    // REQUIRED by Spring context
    public UserAccountServiceImpl() {
        this.repository = null;
    }

    // REQUIRED by TEST CASE (constructor injection)
    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        return repository.save(user);
    }

    @Override
    public Optional<UserAccount> getUser(Long id) {
        return repository.findById(id);
    }

    // 🔴 MISSING METHOD → NOW IMPLEMENTED
    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }
}
