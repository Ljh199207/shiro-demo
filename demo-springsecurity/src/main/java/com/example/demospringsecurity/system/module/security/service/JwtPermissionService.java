package com.example.demospringsecurity.system.module.security.service;

import com.example.demospringsecurity.system.module.sys.entity.Menu;
import com.example.demospringsecurity.system.module.sys.entity.Role;
import com.example.demospringsecurity.system.module.sys.repository.RoleRepository;
import com.example.demospringsecurity.system.module.sys.service.dto.UserDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ljh
 * @date 2019-11-27 14:11
 */
@Service
public class JwtPermissionService {
    private final RoleRepository roleRepository;

    public JwtPermissionService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Collection<GrantedAuthority> mapToGrantedAuthorities(UserDTO user) {

        System.out.println("--------------------loadPermissionByUser:" + user.getUsername() + "---------------------");

        Set<Role> roles = roleRepository.findByUsers_Id(user.getId());
        Set<String> permissions = roles.stream().filter(role -> StringUtils.isNotBlank(role.getPermission())).map(Role::getPermission).collect(Collectors.toSet());
        permissions.addAll(
                roles.stream().flatMap(role -> role.getMenus().stream())
                        .filter(menu -> StringUtils.isNotBlank(menu.getPermission()))
                        .map(Menu::getPermission).collect(Collectors.toSet())
        );
        return permissions.stream().map(permission -> new SimpleGrantedAuthority(permission))
                .collect(Collectors.toList());
    }
}
