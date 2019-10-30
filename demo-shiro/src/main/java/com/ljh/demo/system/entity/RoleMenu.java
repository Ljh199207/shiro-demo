package com.ljh.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * 角色菜单关联表 Entity
 * </p>
 *
 * @author ljh
 * @since 2019-10-30 14:45:19
 */
@Data
@TableName("t_role_menu")
public class RoleMenu {
    /**
     * 菜单/按钮ID
     */
    @TableField("MENU_ID")
    private Long menuId;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private Long roleId;


    public static final String MENU_ID = "MENU_ID";
    public static final String ROLE_ID = "ROLE_ID";
}

