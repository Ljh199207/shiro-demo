package com.ljh.demo.common.runner;

import com.ljh.demo.common.properties.ShiroProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
@Slf4j
public class FebsStartedUpRunner implements ApplicationRunner {
    @Autowired
    private ConfigurableApplicationContext context;
    @Autowired
    private ShiroProperties febsProperties;

    @Value("${server.port:8080}")
    private String port;
    @Value("${server.servlet.context-path:}")
    private String contextPath;
    @Value("${spring.profiles.active}")
    private String active;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (context.isActive()) {
            InetAddress address = InetAddress.getLocalHost();
            String url = String.format("http://%s:%s", address.getHostAddress(), port);
            String loginUrl = febsProperties.getLoginUrl();
            if (StringUtils.isNotBlank(contextPath)) {
                url += contextPath;
            }
            if (StringUtils.isNotBlank(loginUrl)) {
                url += loginUrl;
            }
            log.info(" __    ___   _      ___   _     ____ _____  ____ ");
            log.info("/ /`  / / \\ | |\\/| | |_) | |   | |_   | |  | |_  ");
            log.info("\\_\\_, \\_\\_/ |_|  | |_|   |_|__ |_|__  |_|  |_|__ ");
            log.info("                                                      ");
            log.info("FEBS 权限系统启动完毕，地址：{}", url);

            boolean auto = febsProperties.isAutoOpenBrowser();
            String[] autoEnv = febsProperties.getAutoOpenBrowserEnv();
            if (auto && ArrayUtils.contains(autoEnv, active)) {
                String os = System.getProperty("os.name");
                // 默认为 windows时才自动打开页面
                if (StringUtils.containsIgnoreCase(os, "windows")) {
                    //使用默认浏览器打开系统登录页
                    Runtime.getRuntime().exec("cmd  /c  start " + url);
                }
            }
        }
    }
}
