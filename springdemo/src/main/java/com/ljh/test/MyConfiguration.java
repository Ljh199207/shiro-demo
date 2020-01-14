package com.ljh.test;

import org.apache.poi.poifs.crypt.Encryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfiguration {
    /**
     * singleton
     * prototype
     * @return
     */
    @Bean
    @Scope
    public Encryptor encryptor() {
        // ...
        return null;
    }
}
