package com.example.springbootmybits.aopLog.controller;

import com.example.springbootmybits.aopLog.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljh
 * @date 2019-11-14 14:53
 */
@RestController
public class TestController {
    @Log("执行方法一")
    @GetMapping("/one")
    public void methodOne(String name) { }

    @Log("执行方法二")
    @GetMapping("/two")
    public void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Log("执行方法三")
    @GetMapping("/three")
    public void methodThree(String name, String age) { }
}
