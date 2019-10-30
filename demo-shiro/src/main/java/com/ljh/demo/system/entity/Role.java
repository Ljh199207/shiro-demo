package com.ljh.demo.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 角色表 Entity
 * </p>
 *
 * @author ljh
 * @since 2019-10-30 14:45:19
 */
@Data
@TableName("t_role")
public class Role {
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    private Date modifyTime;

    /**
     * 角色描述
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 角色ID
     */
    @TableId(value = "ROLE_ID", type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 角色对应的菜单（按钮） id
     */
    private transient String menuIds;

    public static final String CREATE_TIME = "CREATE_TIME";
    public static final String MODIFY_TIME = "MODIFY_TIME";
    public static final String REMARK = "REMARK";
    public static final String ROLE_ID = "ROLE_ID";
    public static final String ROLE_NAME = "ROLE_NAME";
}

