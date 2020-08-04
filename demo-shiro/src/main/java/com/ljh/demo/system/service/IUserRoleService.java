package com.ljh.demo.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.system.entity.UserRole;

import java.util.List;

/**
 * 用户角色关联表 Service接口
 *
 * @author ljh
 * @date 2019-10-30 14:45:19
 */
public interface IUserRoleService extends IService<UserRole> {
    /**
     * 查询（分页）
     *
     * @param request  QueryRequest
     * @param userRole userRole
     * @return IPage<UserRole>
     */
    IPage<UserRole> findUserRoles(QueryRequest request, UserRole userRole);

    /**
     * 查询（所有）
     *
     * @param userRole userRole
     * @return List<UserRole>
     */
    List<UserRole> findUserRoles(UserRole userRole);

    /**
     * 新增
     *
     * @param userRole userRole
     */
    void createUserRole(UserRole userRole);

    /**
     * 修改
     *
     * @param userRole userRole
     */
    void updateUserRole(UserRole userRole);

    /**
     * 删除
     *
     * @param userRole userRole
     */
    void deleteUserRole(UserRole userRole);
}
