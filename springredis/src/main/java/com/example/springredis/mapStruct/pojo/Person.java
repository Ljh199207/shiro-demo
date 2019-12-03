package com.example.springredis.mapStruct.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ljh
 * @date 2019-11-28 08:59
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;


}
