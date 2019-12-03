package com.example.springsecurity.repository;

import com.example.springsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
