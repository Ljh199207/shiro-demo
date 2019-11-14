package com.example.springsecurity01.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;

public class AtLoginFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("this is a filter at UsernamePasswordAuthenticationFilter.");
        //继续调用Filter链
        chain.doFilter(request, response);
    }
}
