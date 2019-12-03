package com.ljh.demo.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.system.entity.UserRole;
import com.ljh.demo.system.mapper.UserRoleMapper;
import com.ljh.demo.system.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户角色关联表 Service实现
 *
 * @author ljh
 * @date 2019-10-30 14:45:19
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public IPage<UserRole> findUserRoles(QueryRequest request, UserRole userRole) {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
// TODO 设置查询条件
        Page<UserRole> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserRole> findUserRoles(UserRole userRole) {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
// TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createUserRole(UserRole userRole) {
        this.save(userRole);
    }

    @Override
    @Transactional
    public void updateUserRole(UserRole userRole) {
        this.saveOrUpdate(userRole);
    }

    @Override
    @Transactional
    public void deleteUserRole(UserRole userRole) {
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
// TODO 设置删除条件
        this.remove(wrapper);
    }
}
