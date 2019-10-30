package com.ljh.demo.system.controller;

import com.ljh.demo.common.controller.BaseController;
import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.common.exception.FebsException;
import com.ljh.demo.common.utils.MD5Util;
import com.ljh.demo.system.service.IUserService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

/**
 * @author ljh
 */
@Validated
@RestController
public class LoginController extends BaseController {

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public FebsResponse login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password,
            boolean rememberMe, HttpServletRequest request) throws FebsException {
        password = MD5Util.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        super.login(token);
        return new FebsResponse().success();
    }
    
}
