package com.ljh.demo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljh.demo.system.entity.Menu;

import java.util.List;

/**
 * 菜单表 Mapper
 *
 * @author ljh
 * @date 2019-10-30 14:45:19
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findUserPermissions(String userName);

    List<Menu> findUserMenus(String username);
}
