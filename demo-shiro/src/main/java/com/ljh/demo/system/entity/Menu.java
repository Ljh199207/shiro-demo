package com.ljh.demo.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 菜单表 Entity
 * </p>
 *
 * @author ljh
 * @since 2019-10-30 14:45:19
 */
@Data
@TableName("t_menu")
public class Menu {
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * 菜单/按钮ID
     */
    @TableId(value = "MENU_ID", type = IdType.AUTO)
    private Long menuId;

    /**
     * 菜单/按钮名称
     */
    @TableField("MENU_NAME")
    private String menuName;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    private Date modifyTime;

    /**
     * 排序
     */
    @TableField("ORDER_NUM")
    private Long orderNum;

    /**
     * 上级菜单ID
     */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 权限标识
     */
    @TableField("PERMS")
    private String perms;

    /**
     * 类型 0菜单 1按钮
     */
    @TableField("TYPE")
    private String type;

    /**
     * 菜单URL
     */
    @TableField("URL")
    private String url;


    public static final String CREATE_TIME = "CREATE_TIME";
    public static final String ICON = "ICON";
    public static final String MENU_ID = "MENU_ID";
    public static final String MENU_NAME = "MENU_NAME";
    public static final String MODIFY_TIME = "MODIFY_TIME";
    public static final String ORDER_NUM = "ORDER_NUM";
    public static final String PARENT_ID = "PARENT_ID";
    public static final String PERMS = "PERMS";
    public static final String TYPE = "TYPE";
    public static final String URL = "URL";
}

