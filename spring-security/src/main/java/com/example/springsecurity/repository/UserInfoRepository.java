package com.example.springsecurity.repository;

import com.example.springsecurity.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);

    public UserInfo findByMobile(String mobile);
}
