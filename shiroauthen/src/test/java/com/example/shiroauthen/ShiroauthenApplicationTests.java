package com.example.shiroauthen;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
@SpringBootTest
class ShiroauthenApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public   void getkey(){
        String key = "5F740A2672405BC09FA2E314828BFEF5";
        byte[] keyByte = key.getBytes(StandardCharsets.UTF_8);
        System.out.println(Base64Utils.encodeToString(Arrays.copyOf(keyByte, 16)));
    }

}
