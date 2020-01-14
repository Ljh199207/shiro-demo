package com.ljh.test;

import com.ljh.annotation.MyController;
import org.springframework.beans.factory.annotation.Autowired;

@MyController
public class TestController {

    @Autowired
    private User user;

    public void test() {
        System.out.println("注入成功！");
    }
}
