package com.example.springsecurity01.other.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author user
 */
public class AfterLoginFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("this is a filter after UsernamePasswordAuthenticationFilter.");
        //继续调用Filter链
        chain.doFilter(request, response);
    }
}