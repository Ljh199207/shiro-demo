package com.ljh.demo.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 部门表 Entity
 * </p>
 *
 * @author ljh
 * @since 2019-10-30 14:45:19
 */
@Data
@TableName("t_dept")
public class Dept {
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 部门ID
     */
    @TableId(value = "DEPT_ID", type = IdType.AUTO)
    private Long deptId;

    /**
     * 部门名称
     */
    @TableField("DEPT_NAME")
    private String deptName;

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
     * 上级部门ID
     */
    @TableField("PARENT_ID")
    private Long parentId;


    public static final String CREATE_TIME = "CREATE_TIME";
    public static final String DEPT_ID = "DEPT_ID";
    public static final String DEPT_NAME = "DEPT_NAME";
    public static final String MODIFY_TIME = "MODIFY_TIME";
    public static final String ORDER_NUM = "ORDER_NUM";
    public static final String PARENT_ID = "PARENT_ID";
}

