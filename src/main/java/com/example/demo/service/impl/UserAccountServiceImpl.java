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
    public UserAccount updateUser(Long id, UserAccount updatedUser) {
        for (UserAccount user : users) {
            if (user.getId() != null && user.getId().equals(id)) {
                user.setEmail(updatedUser.getEmail());
                user.setFullName(updatedUser.getFullName());
                return user;
            }
        }
        return null;
    }

    @Override
    public void deactivateUser(Long id) {
        for (UserAccount user : users) {
            if (user.getId() != null && user.getId().equals(id)) {
                user.setActive(false);
                return;
            }
        }
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
