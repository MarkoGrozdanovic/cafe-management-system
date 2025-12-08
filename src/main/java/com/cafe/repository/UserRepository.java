package com.cafe.repository;

import com.cafe.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserName(String username);

    Optional<User> findByUserName(String username);

    boolean existsByEmail(@NotBlank @Size(max = 50) @Email String email);
}
