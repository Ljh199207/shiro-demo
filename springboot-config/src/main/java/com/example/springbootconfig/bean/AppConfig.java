package com.example.springbootconfig.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.springbootconfig.bean")
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
