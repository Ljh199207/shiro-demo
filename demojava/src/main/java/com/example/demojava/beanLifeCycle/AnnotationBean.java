package com.example.demojava.beanLifeCycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @PostConstruct,
 * @PreDestroy
 */

@Component
@Slf4j
public class AnnotationBean {


    @PostConstruct
    public void start() {
        log.info("AnnotationBean start +  @postConstruct");
    }

    @PreDestroy
    public void end() {
        log.info("AnnotationBean start + @PreDestroy");
    }


}
