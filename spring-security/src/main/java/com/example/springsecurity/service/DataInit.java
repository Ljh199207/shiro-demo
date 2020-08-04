package com.example.springsecurity.service;

import com.example.springsecurity.entity.Permission;
import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.UserInfo;
import com.example.springsecurity.repository.PermissionRepository;
import com.example.springsecurity.repository.RoleRepository;
import com.example.springsecurity.repository.UserInfoRepository;
import com.example.springsecurity.util.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataInit {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PermissionRepository permissionRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
    }

    @PostConstruct
    public void dataInit() {

        List<Role> roles = new ArrayList<>();
        Role adminRole = new Role("admin", "管理员");
        Role normalRole = new Role("normal", "普通用户");
        roleRepository.save(adminRole);
        roleRepository.save(normalRole);

        roles.add(adminRole);
        roles.add(normalRole);

        UserInfo admin = new UserInfo();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder().encode("123"));
        admin.setMobile("17777777778");
        admin.setRoles(roles);
        userInfoRepository.save(admin);


        roles = new ArrayList<>();
        roles.add(normalRole);

        UserInfo user = new UserInfo();
        user.setUsername("user");
        user.setPassword(passwordEncoder().encode("123"));
        user.setMobile("17777777777");
        user.setRoles(roles);
        userInfoRepository.save(user);


        Permission permission1 = new Permission();
        permission1.setUrl("/hello/helloUser");
        permission1.setName("普通用户URL");
        permission1.setDescription("普通用户的访问路径");
        permission1.setRoles(roles);
        permissionRepository.save(permission1);

        Permission permission2 = new Permission();
        permission2.setUrl("/hello/helloAdmin");
        permission2.setName("管理员URL");
        permission2.setDescription("管理员的访问路径");
        List<Role> roles2 = new ArrayList<>();
        roles2.add(adminRole);
        permission2.setRoles(roles2);
        permissionRepository.save(permission2);

    }

}

