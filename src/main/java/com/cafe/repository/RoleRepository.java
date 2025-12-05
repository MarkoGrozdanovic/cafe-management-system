package com.cafe.repository;

import com.cafe.model.Role;
import com.cafe.model.enums.ROLES;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(ROLES role);
}
