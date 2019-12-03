package com.example.springsecurity01.other.service;

import com.example.springsecurity01.other.entity.UserInfo;

/**
 * @author user
 */
public interface UserInfoService {
    public UserInfo findByUsername(String username);

    public UserInfo findByMobile(String mobile);
}
