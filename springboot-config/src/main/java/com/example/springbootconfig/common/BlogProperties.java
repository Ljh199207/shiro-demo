package com.example.springbootconfig.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author user
 */
@Component
@Data
public class BlogProperties {

    @Value("${mrbird.blog.name}")
    private String name;
    @Value("${mrbird.blog.title}")
    private String title;
}
