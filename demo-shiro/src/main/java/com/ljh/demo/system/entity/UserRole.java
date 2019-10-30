package com.ljh.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * 用户角色关联表 Entity
 * </p>
 *
 * @author ljh
 * @since 2019-10-30 14:45:19
 */
@Data
@TableName("t_user_role")
public class UserRole {
    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private Long roleId;

    /**
     * 用户ID
     */
    @TableField("USER_ID")
    private Long userId;


    public static final String ROLE_ID = "ROLE_ID";
    public static final String USER_ID = "USER_ID";
}

