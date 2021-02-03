package com.example.demojava.beanLifeCycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SpringBeanFactoryAware implements BeanFactoryAware, BeanNameAware {
    private BeanFactory beanFactory;
    private String name;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("BeanFactoryAware  + start ");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        log.info("BeanNameAware  + start ");
        this.name = s;
    }
}
