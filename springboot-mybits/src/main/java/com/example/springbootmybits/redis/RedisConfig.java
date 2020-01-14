package com.example.springbootmybits.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public KeyGenerator keyGenerator(){
       return  new KeyGenerator() {
           @Override
           public Object generate(Object target, Method method, Object... params) {
               StringBuilder sb = new StringBuilder();
               sb.append(target.getClass().getName());
               sb.append(method.getName());
               if(params!=null&&params.length>0){
                   Arrays.stream(params).forEach(e->sb.append(e.toString()));
               }
               return sb.toString();
           }
       };
    }
}
