package com.example.springsecurity01.other.repository;

import com.example.springsecurity01.other.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 */
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
