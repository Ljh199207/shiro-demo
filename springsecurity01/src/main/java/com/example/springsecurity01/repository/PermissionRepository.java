package com.example.springsecurity01.repository;

import com.example.springsecurity01.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 */
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
