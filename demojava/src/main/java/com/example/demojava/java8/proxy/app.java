package com.example.demojava.java8.proxy;

import java.lang.reflect.Proxy;

public class app {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        DynamicProxy proxy = new DynamicProxy(realSubject);

        Subject subject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), proxy);
        subject.test();

        Subject subject1 = (Subject) new CligbProxy().createProxy(new RealSubject());
        subject1.test();
    }
}
