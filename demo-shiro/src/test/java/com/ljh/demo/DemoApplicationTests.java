package com.ljh.demo;

import com.ljh.demo.common.utils.AddressUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String cityInfo = AddressUtil.getCityInfo("192.168.215.149");
        System.out.println("123");
    }
}
