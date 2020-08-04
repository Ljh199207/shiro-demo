package com.example.springbootconfig.common;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author user
 */
@Data
//@ConfigurationProperties(prefix = "mrbird.blog")
public class ConfigBean {
    @Min()
    private String name;
    private String title;

    private String wholeTitle;
}
