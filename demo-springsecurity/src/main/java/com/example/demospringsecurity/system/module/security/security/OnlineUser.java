package com.example.demospringsecurity.system.module.security.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zheng Jie
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlineUser implements Serializable {

    private String userName;

    private String job;

    private String browser;

    private String ip;

    private String address;

    private String key;

    private Date loginTime;


}
