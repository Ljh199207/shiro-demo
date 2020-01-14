package com.example.springbootmybits.mybatis.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ljh
 */
@Data
public class Student implements Serializable {

    private String sno;
    private String name;
    private String sex;

}
