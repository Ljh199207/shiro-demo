package com.example.springsecurity01.other.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class UserInfo implements Serializable {

    /*public enum Role {
        admin, normal
    }*/
    //主键.
    @Id
    @GeneratedValue
    private long uid;
    //用户名.
    private String username;

    private String mobile;
    //密码.
    private String password;

    private Boolean enabled;

  /*  @Enumerated(EnumType.STRING)
    private Role role;*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

}
