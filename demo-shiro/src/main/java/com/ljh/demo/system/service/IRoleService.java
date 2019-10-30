package com.ljh.demo.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.system.entity.Role;

import java.util.List;

/**
 * 角色表 Service接口
 *
 * @author ljh
 * @date 2019-10-30 14:45:19
 */
public interface IRoleService extends IService<Role> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param role    role
     * @return IPage<Role>
     */
    IPage<Role> findRoles(QueryRequest request, Role role);

    /**
     * 查询（所有）
     *
     * @param role role
     * @return List<Role>
     */
    List<Role> findRoles(Role role);

    /**
     * 新增
     *
     * @param role role
     */
    void createRole(Role role);

    /**
     * 修改
     *
     * @param role role
     */
    void updateRole(Role role);

    /**
     * 删除
     *
     * @param role role
     */
    void deleteRole(Role role);

    /**
     * 查找用户的角色
     * @param userName
     * @return
     */
    List<Role> findUserRole(String userName);
}
