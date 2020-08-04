package com.example.springbootmybits.jpa.repository;

import com.example.springbootmybits.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("from User u where u.username like %:name% ")
    User findByName(@Param("name") String name);

    @Modifying
    @Query("update User u SET u.username=:name,u.password =:password where u.id = :id ")
    Integer updateUser(@Param("id") Long id, @Param("name") String name, @Param("password") String password);


    @Modifying
    @Query(value = "update j_user  u SET u.username=:name,u.password =:password where u.id = :id ", nativeQuery = true)
    Integer updateUser2(@Param("id") Long id, @Param("name") String name, @Param("password") String password);

}
