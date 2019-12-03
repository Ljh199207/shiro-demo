package com.ljh.demo.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.system.entity.User;

import java.util.List;

/**
 * 用户表 Service接口
 *
 * @author ljh
 * @date 2019-10-29 11:40:15
 */
public interface IUserService extends IService<User> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param user    user
     * @return IPage<User>
     */
    IPage<User> findUsers(QueryRequest request, User user);

    /**
     * 查询（所有）
     *
     * @param user user
     * @return List<User>
     */
    List<User> findUsers(User user);

    /**
     * 新增
     *
     * @param user user
     */
    void createUser(User user);

    /**
     * 修改
     *
     * @param user user
     */
    void updateUser(User user);

    /**
     * 删除
     *
     * @param user user
     */
    void deleteUser(User user);



    User findByName(String userName);


    /**
     * 更新用户登录时间
     *
     * @param username 用户名
     */
    void updateLoginTime(String username);
    /**
     * 查找用户详细信息
     *
     * @param request request
     * @param user    用户对象，用于传递查询条件
     * @return IPage
     */
    IPage<User> findUserDetail(User user, QueryRequest request);
}
