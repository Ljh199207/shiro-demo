package com.ljh.demo.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljh.demo.common.entity.MenuTree;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.system.entity.Menu;

import java.util.List;

/**
 * 菜单表 Service接口
 *
 * @author ljh
 * @date 2019-10-30 14:45:19
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param menu    menu
     * @return IPage<Menu>
     */
    IPage<Menu> findMenus(QueryRequest request, Menu menu);

    /**
     * 查询（所有）
     *
     * @param menu menu
     * @return List<Menu>
     */
    List<Menu> findMenus(Menu menu);

    /**
     * 新增
     *
     * @param menu menu
     */
    void createMenu(Menu menu);

    /**
     * 修改
     *
     * @param menu menu
     */
    void updateMenu(Menu menu);

    /**
     * 删除
     *
     * @param menu menu
     */
    void deleteMenu(Menu menu);

    /**
     * 获取用户权限集
     * @param userName
     * @return
     */
    List<Menu> findUserPermissions(String userName);

    MenuTree<Menu> findUserMenus(String username);
}
