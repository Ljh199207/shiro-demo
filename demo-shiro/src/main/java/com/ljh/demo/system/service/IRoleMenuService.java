package com.ljh.demo.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.system.entity.RoleMenu;

import java.util.List;

/**
* 角色菜单关联表 Service接口
*
* @author ljh
* @date 2019-10-30 14:45:19
*/
public interface IRoleMenuService extends IService<RoleMenu> {
/**
* 查询（分页）
*
* @param request QueryRequest
* @param roleMenu roleMenu
* @return IPage<RoleMenu>
*/
IPage<RoleMenu> findRoleMenus(QueryRequest request, RoleMenu roleMenu);

/**
* 查询（所有）
*
* @param roleMenu roleMenu
* @return List<RoleMenu>
*/
List<RoleMenu> findRoleMenus(RoleMenu roleMenu);

/**
* 新增
*
* @param roleMenu roleMenu
*/
void createRoleMenu(RoleMenu roleMenu);

/**
* 修改
*
* @param roleMenu roleMenu
*/
void updateRoleMenu(RoleMenu roleMenu);

/**
* 删除
*
* @param roleMenu roleMenu
*/
void deleteRoleMenu(RoleMenu roleMenu);
}
