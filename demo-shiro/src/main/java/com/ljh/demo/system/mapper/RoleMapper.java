package com.ljh.demo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljh.demo.system.entity.Role;

import java.util.List;

/**
* 角色表 Mapper
*
* @author ljh
* @date 2019-10-30 14:45:19
*/
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> findUserRole(String userName);
}
