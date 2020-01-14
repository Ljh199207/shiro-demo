package com.example.springbootconfig.bean;

import org.springframework.stereotype.Component;

@Component
public class Dependency1 {

    public void dependency1() {
        System.out.println("Dependency1");
    }
}
