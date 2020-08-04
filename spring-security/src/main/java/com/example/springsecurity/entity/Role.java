package com.example.springsecurity.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Role implements Serializable {
    @Id
    @GeneratedValue
    //主键.
    private long rid;
    //角色名称.
    private String name;
    //角色描述.
    private String description;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Role() {

    }
}
