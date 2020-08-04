package com.ljh.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigA {

    @Bean
    public String a() {
        return "A";
    }
}
