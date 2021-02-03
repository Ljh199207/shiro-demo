package com.example.demojava.beanLifeCycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * InitializingBean,
 * DisposableBean 这两个接口，也是在初始化以及销毁阶段调用：
 */
@Component
@Slf4j
public class SpringLifeCycleService implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
       log.info("DisposableBean 接口 end");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
      log.info("InitializingBean 接口 end");
    }
}
