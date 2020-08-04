package com.ljh.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigA.class)
public class ConfigB {

    public String b() {
        return "B";
    }
}
