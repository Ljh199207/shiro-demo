package com.example.springbootconfig;

import com.example.springbootconfig.event.MyTestEventPubLisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Locale;

@SpringBootTest
@EnableAsync
class SpringbootConfigApplicationTests {

    @Autowired
    public MessageSource messageSource;

    @Autowired
    public MyTestEventPubLisher myTestEventPubLisher;

    @Test
    void contextLoads() {
        String msg1 = this.messageSource.getMessage("login.sign", null, Locale.US);
        System.out.println(msg1);
    }

    @Test
    void MyTestEventPubLisher() {
        myTestEventPubLisher.pushListener("我来了");
    }
}
