package com.example.springbootconfig.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljh
 */
@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;

    @Autowired
    private ConfigBean configBean;

    @Autowired
    private TestBeanConfig testBeanConfig;

    @RequestMapping("/")
    String index() {
       // return blogProperties.getName()+"——"+blogProperties.getTitle();
       // return configBean.getName()+"------"+configBean.getTitle()+"--"+configBean.getWholeTitle();
        return testBeanConfig.getName()+"----"+testBeanConfig.getAge();
    }

}
