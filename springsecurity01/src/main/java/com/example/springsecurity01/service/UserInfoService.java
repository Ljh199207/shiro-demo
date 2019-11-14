package com.example.springsecurity01.service;

import com.example.springsecurity01.entity.UserInfo;

/**
 * @author user
 */
public interface UserInfoService {
    public UserInfo findByUsername(String username);

    public UserInfo findByMobile(String mobile);
}
