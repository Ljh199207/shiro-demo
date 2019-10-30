package com.ljh.demo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljh.demo.system.entity.User;

/**
* 用户表 Mapper
*
* @author ljh
* @date 2019-10-29 11:40:15
*/
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户
     */
    User findByName(String username);
}
