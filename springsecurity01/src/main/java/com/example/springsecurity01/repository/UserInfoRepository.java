package com.example.springsecurity01.repository;

import com.example.springsecurity01.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);

    public UserInfo findByMobile(String mobile);
}
