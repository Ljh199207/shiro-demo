package com.example.springsecurity.service.impl;

import com.example.springsecurity.entity.UserInfo;
import com.example.springsecurity.repository.UserInfoRepository;
import com.example.springsecurity.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author user
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }

    @Override
    public UserInfo findByMobile(String mobile) {
        return userInfoRepository.findByMobile(mobile);
    }
}
