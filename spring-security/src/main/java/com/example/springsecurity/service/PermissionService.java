package com.example.springsecurity.service;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.Map;

/**
 * @author ljh
 */
public interface PermissionService {
    public Map<String, Collection<ConfigAttribute>> getPermissionMap();
}
