package com.example.springsecurity.service.impl;

import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.UserInfo;
import com.example.springsecurity.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("CustomUserDetailService.loadUserByUsername()");
        //通过username 获取用户信息
        UserInfo user = userInfoService.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        //定义权限列表.
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

        }
        User userDetails = new User(user.getUsername(), user.getPassword(), authorities);
        return userDetails;
    }


}
