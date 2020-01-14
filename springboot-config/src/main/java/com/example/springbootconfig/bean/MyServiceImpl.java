package com.example.springbootconfig.bean;

import org.springframework.stereotype.Component;

@Component
public class MyServiceImpl implements MyService {
    @Override
    public void doStuff() {
        System.out.println("doStuff");
    }
}
