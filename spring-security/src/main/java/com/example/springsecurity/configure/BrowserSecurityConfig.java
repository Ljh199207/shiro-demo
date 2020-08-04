package com.example.springsecurity.configure;

import com.example.springsecurity.filter.ValidateCodeFilter;
import com.example.springsecurity.security.MyAuthenticationFailureHandler;
import com.example.springsecurity.security.MyAuthenticationSucessHandler;
import com.example.springsecurity.service.impl.CustomUserDetailService;
import com.example.springsecurity.sms.SmsAuthenticationConfig;
import com.example.springsecurity.sms.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.sql.DataSource;

/**
 * @author ljh
 * /**EnableGlobalMethodSecurity
 * *   配置 Security 免认证
 * *   EnableGlobalMethodSecurity  开启Spring方法级安全
 * *   1）prePostEnabled :决定Spring Security的前注解是否可用 [@PreAuthorize,@PostAuthorize,..]
 * *
 * * （2）secureEnabled : 决定是否Spring Security的保障注解 [@Secured] 是否可用。
 * *
 * * （3）jsr250Enabled ：决定 JSR-250 annotations 注解[@RolesAllowed..] 是否可用。
 * @EnableWebSecurity 1: 加载了WebSecurityConfiguration配置类, 配置安全认证策略。
 * 2: 加载了AuthenticationConfiguration, 配置了认证信息。
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationSucessHandler authenticationSucessHandler;

    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 用来防止token被修改的key
     */
    private String rememberMeKey = "wuqian2019";
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SmsCodeFilter smsCodeFilter;

    @Autowired
    private SmsAuthenticationConfig smsAuthenticationConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加验证码校验过滤器
                .addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加短信验证码校验过滤器
                .formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                .loginPage("/authentication/require") // 登录跳转 URL
                .loginProcessingUrl("/login") // 处理表单登录 URL
                .successHandler(authenticationSucessHandler) // 处理登录成功
                .failureHandler(authenticationFailureHandler) // 处理登录失败
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/authentication/require",
                        "/login.html", "/code/image", "/code/sms").permitAll() // 无需认证的请求路径
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认证
                .and()
                .csrf().disable()
                .apply(smsAuthenticationConfig); // 将短信验证码认证配置加到 Spring Security 中
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        System.out.println("WebSecurityConfig.tokenBasedRememberMeServices()=" + customUserDetailService);
        TokenBasedRememberMeServices tbrms = new TokenBasedRememberMeServices(rememberMeKey, customUserDetailService);
        // [可选]需要配置cookie的过期时间，默认过时时间1209600秒，即2个星期。这里设置cookie过期时间为1天
        tbrms.setTokenValiditySeconds(60 * 60 * 24 * 1);
        // 设置checkbox的参数名为rememberMe（默认为remember-me），
        //注意如果是ajax请求，参数名不是checkbox的name而是在ajax的data里
        //tbrms.setParameter("rememberMe");
        return tbrms;
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }
}
