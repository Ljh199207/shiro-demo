package com.ljh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
      /*  TestController testController = BeanHelper.getBean(TestController.class);
        testController.test();*/
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigB.class);
        ConfigA a = ctx.getBean(ConfigA.class);
        System.out.println(a.a());
        ConfigB b = ctx.getBean(ConfigB.class);
        System.out.println(b.b());
    }
}
