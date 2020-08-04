package com.ljh.demo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljh.demo.system.entity.User;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 查找用户详细信息
     *
     * @param page 分页对象
     * @param user 用户对象，用于传递查询条件
     * @return Ipage
     */
    IPage<User> findUserDetailPage(Page page, @Param("user") User user);
}
