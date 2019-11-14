package com.example.springsecurity01.repository;

import com.example.springsecurity01.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
