package com.example.springbootconfig.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author user
 */
@Configuration
@ConfigurationProperties(prefix = "test")
@PropertySource("classpath:test.properties")
@Data
public class TestBeanConfig {

    private String name;

    private String age;
}
