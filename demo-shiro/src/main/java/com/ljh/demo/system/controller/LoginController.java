package com.ljh.demo.system.controller;

import com.ljh.demo.common.controller.BaseController;
import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.common.exception.FebsException;
import com.ljh.demo.common.utils.CaptchaUtil;
import com.ljh.demo.common.utils.MD5Util;
import com.ljh.demo.system.service.IUserService;
import com.wf.captcha.base.Captcha;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            @NotBlank(message = "{required}") String verifyCode,
            boolean rememberMe, HttpServletRequest request) throws FebsException {
        if(!CaptchaUtil.verify(verifyCode,request)){
            throw new FebsException("验证码错误！");
        }
        password = MD5Util.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        super.login(token);
        return new FebsResponse().success();
    }

    @GetMapping("images/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.outPng(110, 34, 4, Captcha.TYPE_ONLY_NUMBER, request, response);
    }
    
}
