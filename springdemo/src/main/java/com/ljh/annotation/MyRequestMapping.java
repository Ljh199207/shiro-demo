package com.ljh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRequestMapping {
    /**
     * 请求路径
     *
     * @return
     */
    String value() default "";

    /**
     * 请求方法
     *
     * @return
     */
    RequestMethod method() default RequestMethod.GET;

    //请求方法枚举类
    public enum RequestMethod {
        GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
    }
}
