package com.example.demojava.java8.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CligbProxy implements MethodInterceptor {
    Object targetObject;

    public Object createProxy(Object obj) {
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object proxyObj = enhancer.create();
        return proxyObj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("this is Dynamic CligbProxy invode");
        if (targetObject != null) {
            result = method.invoke(targetObject, objects);
        }
        return result;
    }
}
