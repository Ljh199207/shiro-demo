package com.example.springbootmybits.jpa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeopleVo {

    private String name;

    private String  sex;

    private String birth;

    private String phone;

    private String address;

}
