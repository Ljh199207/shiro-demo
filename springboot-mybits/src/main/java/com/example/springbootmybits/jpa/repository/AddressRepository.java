package com.example.springbootmybits.jpa.repository;

import com.example.springbootmybits.jpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepository extends JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {

}
