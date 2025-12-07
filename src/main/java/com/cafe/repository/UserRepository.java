package com.cafe.repository;

import com.cafe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserName(String username);

    Optional<User> findByUserName(String username);
}
