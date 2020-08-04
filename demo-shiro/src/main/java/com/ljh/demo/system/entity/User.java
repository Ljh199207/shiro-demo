package com.ljh.demo.system.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表 Entity
 * </p>
 *
 * @author ljh
 * @since 2019-10-29 11:40:15
 */
@Data
@TableName("t_user")
@ExcelTarget("userEntity")
public class User implements Serializable {

    private static final long serialVersionUID = -4352868070794165001L;

    // 用户状态：有效
    public static final String STATUS_VALID = "1";
    // 用户状态：锁定
    public static final String STATUS_LOCK = "0";
    // 默认头像
    public static final String DEFAULT_AVATAR = "default.jpg";
    // 默认密码
    public static final String DEFAULT_PASSWORD = "1234qwer";
    // 性别男
    public static final String SEX_MALE = "0";
    // 性别女
    public static final String SEX_FEMALE = "1";
    // 性别保密
    public static final String SEX_UNKNOW = "2";
    // 黑色主题
    public static final String THEME_BLACK = "black";
    // 白色主题
    public static final String THEME_WHITE = "white";
    // TAB开启
    public static final String TAB_OPEN = "1";
    // TAB关闭
    public static final String TAB_CLOSE = "0";


    /**
     * 用户 ID
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @TableField("USERNAME")
    @Size(min = 4, max = 10, message = "{range}")
    @Excel(name = "用户名", width = 20)
    private String username;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 部门 ID
     */
    @TableField("DEPT_ID")
    private Long deptId;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    @Size(max = 50, message = "{noMoreThan}")
    @Email(message = "{email}")
    @Excel(name = "邮箱", width = 20)
    private String email;

    /**
     * 联系电话
     */
    @TableField("MOBILE")
    @Excel(name = "联系电话", width = 30)
    private String mobile;

    /**
     * 状态 0锁定 1有效
     */
    @TableField("STATUS")
    @NotBlank(message = "{required}")
    @Excel(name = "状态", replace = {"锁定_0", "有效_1"}, width = 20)
    private String status;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    @Excel(name = "创建时间", width = 40, format = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    @Excel(name = "修改时间", format = "yyyy-MM-dd", width = 40)
    private Date modifyTime;

    /**
     * 最近访问时间
     */
    @TableField("LAST_LOGIN_TIME")
    @Excel(name = "最近访问时间", format = "yyyy-MM-dd", width = 40)
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒", timezone = "GMT+8")
    private Date lastLoginTime;

    /**
     * 性别 0男 1女 2 保密
     */
    @TableField("SSEX")
    @NotBlank(message = "{required}")
    @Excel(name = "性别", replace = {"男_0", "女_1", "保密_2"}, width = 20)
    private String sex;

    /**
     * 头像
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 主题
     */
    @TableField("THEME")
    private String theme;

    /**
     * 是否开启 tab 0开启，1关闭
     */
    @TableField("IS_TAB")
    private String isTab;

    /**
     * 描述
     */
    @TableField("DESCRIPTION")
    @Size(max = 100, message = "{noMoreThan}")
    @Excel(name = "个人描述", width = 40)
    private String description;

    /**
     * 部门名称
     */
    @Excel(name = "部门", width = 20)
    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private String createTimeFrom;
    @TableField(exist = false)
    private String createTimeTo;
    /**
     * 角色 ID
     */
    @NotBlank(message = "{required}")
    @TableField(exist = false)
    private String roleId;

    @Excel(name = "角色", width = 20)
    @TableField(exist = false)
    private String roleName;

    public Long getId() {
        return userId;
    }


    public static final String AVATAR = "AVATAR";
    public static final String CREATE_TIME = "CREATE_TIME";
    public static final String DEPT_ID = "DEPT_ID";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String EMAIL = "EMAIL";
    public static final String IS_TAB = "IS_TAB";
    public static final String LAST_LOGIN_TIME = "LAST_LOGIN_TIME";
    public static final String MOBILE = "MOBILE";
    public static final String MODIFY_TIME = "MODIFY_TIME";
    public static final String PASSWORD = "PASSWORD";
    public static final String SSEX = "SSEX";
    public static final String STATUS = "STATUS";
    public static final String THEME = "THEME";
    public static final String USER_ID = "USER_ID";
    public static final String USERNAME = "USERNAME";
}

