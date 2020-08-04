package com.example.springbootmybits.jpa.repository;

import com.example.springbootmybits.jpa.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorityRepository extends JpaRepository<Authority, Long>, JpaSpecificationExecutor<Authority> {

    Authority findByName(String name);

}
