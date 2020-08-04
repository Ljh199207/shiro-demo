package com.example.shiroauthen.dao;

import com.example.shiroauthen.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ljh
 */
@Mapper
public interface UserMapper {

    User findByUserName(String userName);
}
