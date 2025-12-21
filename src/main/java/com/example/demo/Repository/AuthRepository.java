package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByEmail(String email);

    boolean existsByEmail(String email);
}
