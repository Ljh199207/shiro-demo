package com.example.springsecurity01.other.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Permission implements Serializable {

    @Id
    @GeneratedValue
    //主键.
    private long id;
    //权限名称.
    private String name;
    //权限描述.
    private String description;

    /**
     * 注意：Permission 表的url通配符为两颗星，比如说 /user下的所有url，应该写成 /user/**;
     */
    //授权链接
    private String url;
    //父节点id.
    private long pid;

    // 角色 - 权限是多对多的关系
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RolePermission", joinColumns = {@JoinColumn(name = "permission_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;
}
