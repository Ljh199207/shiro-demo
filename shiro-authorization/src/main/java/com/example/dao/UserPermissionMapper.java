package com.example.dao;

import com.example.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserPermissionMapper {

    List<Permission> findByUserName(@Param("userName") String userName);
}
