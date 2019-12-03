package com.example.springsecurity01.other.repository;

import com.example.springsecurity01.other.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
