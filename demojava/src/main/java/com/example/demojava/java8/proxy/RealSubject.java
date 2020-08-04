package com.example.demojava.java8.proxy;

public class RealSubject implements Subject {
    @Override
    public void test() {
        System.out.println("this is dynamic RealSubject test");
    }
}
