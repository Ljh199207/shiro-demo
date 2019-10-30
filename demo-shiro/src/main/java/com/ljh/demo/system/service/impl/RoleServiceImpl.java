package com.ljh.demo.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.system.entity.Role;
import com.ljh.demo.system.mapper.RoleMapper;
import com.ljh.demo.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色表 Service实现
 *
 * @author ljh
 * @date 2019-10-30 14:45:19
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public IPage<Role> findRoles(QueryRequest request, Role role) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
// TODO 设置查询条件
        Page<Role> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Role> findRoles(Role role) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
// TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createRole(Role role) {
        this.save(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        this.saveOrUpdate(role);
    }

    @Override
    @Transactional
    public void deleteRole(Role role) {
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
// TODO 设置删除条件
        this.remove(wrapper);
    }

    /**
     * 查找用户的角色
     *
     * @param userName
     * @return
     */
    @Override
    public List<Role> findUserRole(String userName) {
        return this.baseMapper.findUserRole(userName);
    }
}
