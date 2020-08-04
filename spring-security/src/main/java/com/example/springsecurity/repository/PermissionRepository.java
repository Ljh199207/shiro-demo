package com.example.springsecurity.repository;

import com.example.springsecurity.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
