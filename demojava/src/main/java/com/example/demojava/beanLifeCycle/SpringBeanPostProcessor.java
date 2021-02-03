package com.example.demojava.beanLifeCycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SpringBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("springLifeCycle".equals(beanName)){
            log.info("BeanPostProcessor     +   postProcessAfterInitialization ");
        }

        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("annotationBean".equals(beanName)){
            log.info("BeanPostProcessor     +   postProcessBeforeInitialization ");
        }
        return bean;
    }
}
