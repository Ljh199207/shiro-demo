package com.example.demojava.java8.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    Object mObj;

    public DynamicProxy(Object pObj) {
        mObj = pObj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result = null;
        System.out.println("this is Dynamic proxy invode");
        if (mObj != null) {
            result = method.invoke(mObj, objects);
        }

        return result;
    }
}
