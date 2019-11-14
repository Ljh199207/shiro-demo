package com.example.springsecurity01.service.impl;

import com.example.springsecurity01.entity.UserInfo;
import com.example.springsecurity01.repository.UserInfoRepository;
import com.example.springsecurity01.service.UserInfoService;
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
