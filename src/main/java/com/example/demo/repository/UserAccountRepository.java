package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    // ✅ LOGIN (USED BY UserAccountServiceImpl)
    Optional<UserAccount> findByEmailAndPassword(String email, String password);

    // ✅ SECURITY (USED BY CustomUserDetailsService)
    Optional<UserAccount> findByEmail(String email);

    // ✅ REGISTER VALIDATION (USED BY AuthServiceImpl)
    boolean existsByEmail(String email);
}
