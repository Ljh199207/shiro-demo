package com.example.springsecurity01.other.service.impl;

import com.example.springsecurity01.other.entity.UserInfo;
import com.example.springsecurity01.other.repository.UserInfoRepository;
import com.example.springsecurity01.other.service.UserInfoService;
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
