package com.example.springsecurity01.configure;

import com.example.springsecurity01.filter.ValidateCodeFilter;
import com.example.springsecurity01.service.impl.CustomUserDetailService;
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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定义哪些URL需要被保护、哪些不需要被保护
        //http.addFilterAfter(new AfterLoginFilter(), UsernamePasswordAuthenticationFilter.class);
        // http.addFilterAt(new AtLoginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);
        //http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
                // 设置所有人都可以访问登录页面
                .antMatchers("/login").permitAll()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/test/**", "/code/image","/code/sms", "/test1/**").permitAll()
                .antMatchers("/res/**/*.{js,html}").permitAll()

                .anyRequest().access("@authService.canAccess(request,authentication)")
                // 任何请求,登录后可以访问
                // .anyRequest().authenticated()
                /*.and()
                .rememberMe().key(rememberMeKey)
                .rememberMeServices(rememberMeServices())*/
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60)
                .userDetailsService(userDetailsService())
                //.and().apply(smsAuthenticationConfig)
                .and()
                .formLogin().loginPage("/login")
                ;
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
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }
}
