package com.example.springbootconfig.message;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Message {

    private final MessageSource messageSource;

    public Message(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void testMessage()
    {
        String msg1 = this.messageSource.getMessage("login.password", null, Locale.US);
        System.out.println(msg1);

    }

}
