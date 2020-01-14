package com.example.springbootconfig;

import com.example.springbootconfig.common.ConfigBean;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author ljh
 */
@SpringBootApplication
@EnableConfigurationProperties(value = {ConfigBean.class})
public class SpringbootConfigApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringbootConfigApplication.class);
        //关闭banner
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
