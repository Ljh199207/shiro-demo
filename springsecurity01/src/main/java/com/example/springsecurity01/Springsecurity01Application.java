package com.example.springsecurity01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * jwt
 * 1、搭建springboot工程
 * 2、导入springSecurity跟jwt的依赖
 * 3、用户的实体类，dao层，service层（真正开发时再写，这里就直接调用dao层操作数据库）
 * 4、实现UserDetailsService接口
 * 5、实现UserDetails接口
 * 6、验证用户登录信息的拦截器
 * 7、验证用户权限的拦截器
 * 8、springSecurity配置
 * 9、认证的Controller以及测试的controller
 */
@SpringBootApplication
public class Springsecurity01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springsecurity01Application.class, args);
    }

}
