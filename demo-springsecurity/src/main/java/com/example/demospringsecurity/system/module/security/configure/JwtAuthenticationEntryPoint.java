package com.example.demospringsecurity.system.module.security.configure;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author ljh
 * @date 2019-11-27 13:56
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        // 当用户尝试访问安全的REST资源而不提供任何凭据时，将调用此方法发送401 响应
        // 当用户尝试访问安全的REST资源而不提供任何凭据时，将调用此方法发送401 响应
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e == null ? "Unauthorized" : e.getMessage());
    }
}
