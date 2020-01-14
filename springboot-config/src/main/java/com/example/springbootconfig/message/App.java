package com.example.springbootconfig.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Message.class);
        Message myService = ctx.getBean(Message.class);
        myService.testMessage();

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
