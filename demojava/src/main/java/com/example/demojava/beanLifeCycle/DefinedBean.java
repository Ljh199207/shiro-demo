package com.example.demojava.beanLifeCycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DefinedBean {

    @Bean(value = "springLifeCycle",initMethod ="start",destroyMethod = "destroy")
    public SpringLifeCycle getBean() {
        SpringLifeCycle springLifeCycle = new SpringLifeCycle();
        return springLifeCycle;
    }


    public class SpringLifeCycle {

        public void start() {
            log.info("@Bean 自定义 start");
        }

        public void destroy() {
            log.info("@Bean 自定义 destroy");
        }
    }
}
