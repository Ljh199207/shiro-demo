package com.example.springbootconfig.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Dependency1 myService = ctx.getBean(Dependency1.class);
        myService.dependency1();

        //
       /* ApplicationContext ctx1 = new  AnnotationConfigApplicationContext(MyServiceImpl.class,Dependency1.class);
        MyService myService1 = ctx.getBean(MyService.class);
        myService1.doStuff();*/
        //
        /*AnnotationConfigApplicationContext applicationContext =  new  AnnotationConfigApplicationContext();
        applicationContext.register(MyServiceImpl.class,Dependency1.class);
        applicationContext.refresh();
        Dependency1 myService2 = applicationContext.getBean(Dependency1.class);
        myService2.dependency1();*/

    }
}
