package com.example.demospringsecurity.test;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ljh
 * @date 2019-12-05 15:37
 */
@Data
public class TestEntity implements Serializable {

    private Integer id;
    private String name;
}
