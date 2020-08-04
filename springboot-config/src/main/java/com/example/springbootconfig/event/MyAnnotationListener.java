package com.example.springbootconfig.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
public class MyAnnotationListener {

    @EventListener
    public void listener1(MyTestEvent event) {
        System.out.println("注解监听器1:" + event.getMsg());
    }

    @Async
    @EventListener
    public void listener2(MyTestEvent event) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("注解监听器2:" + event.getMsg());
    }

    @Bean
    public ThreadPoolTaskExecutor asyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(30);
        executor.setThreadNamePrefix("Febs-Async-Thread");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}
