package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final List<UserAccount> users = new ArrayList<>();

    @Override
    public UserAccount createUser(UserAccount user) {
        users.add(user);
        return user;
    }

    @Override
    public UserAccount getUserById(Long id) {
        return users.stream()
                .filter(u -> u.getId() != null && u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return users;
    }
}
