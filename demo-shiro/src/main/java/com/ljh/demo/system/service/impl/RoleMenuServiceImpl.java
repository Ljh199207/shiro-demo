package com.ljh.demo.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.system.entity.RoleMenu;
import com.ljh.demo.system.mapper.RoleMenuMapper;
import com.ljh.demo.system.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 角色菜单关联表 Service实现
*
* @author ljh
* @date 2019-10-30 14:45:19
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

@Autowired
private RoleMenuMapper roleMenuMapper;

@Override
public IPage<RoleMenu> findRoleMenus(QueryRequest request, RoleMenu roleMenu) {
LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
// TODO 设置查询条件
Page<RoleMenu> page = new Page<>(request.getPageNum(), request.getPageSize());
return this.page(page, queryWrapper);
}

@Override
public List<RoleMenu> findRoleMenus(RoleMenu roleMenu) {
LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
// TODO 设置查询条件
return this.baseMapper.selectList(queryWrapper);
}

@Override
@Transactional
public void createRoleMenu(RoleMenu roleMenu) {
this.save(roleMenu);
}

@Override
@Transactional
public void updateRoleMenu(RoleMenu roleMenu) {
this.saveOrUpdate(roleMenu);
}

@Override
@Transactional
public void deleteRoleMenu(RoleMenu roleMenu) {
LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<>();
// TODO 设置删除条件
this.remove(wrapper);
}
}
