package com.example.springbootconfig.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Message {

    @Autowired
    private MessageSource messageSource;


    public void testMessage() {
        String msg1 = this.messageSource.getMessage("login.password", null, Locale.US);
        System.out.println(msg1);

    }

}
