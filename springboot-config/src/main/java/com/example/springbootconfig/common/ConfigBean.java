package com.example.springbootconfig.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * @author user
 */
@Data
@ConfigurationProperties(prefix = "mrbird.blog")
public class ConfigBean {

    private String name;
    private String title;

    private String wholeTitle;
}
