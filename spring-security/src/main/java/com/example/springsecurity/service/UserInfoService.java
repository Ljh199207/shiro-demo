package com.example.springsecurity.service;


import com.example.springsecurity.entity.UserInfo;

/**
 * @author user
 */
public interface UserInfoService {
    public UserInfo findByUsername(String username);

    public UserInfo findByMobile(String mobile);
}
