package com.ljh.demo.system.controller;

import com.ljh.demo.common.controller.BaseController;
import com.ljh.demo.common.entity.FebsConstant;
import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.common.utils.FebsUtil;
import com.ljh.demo.system.entity.User;
import com.ljh.demo.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;


/**
 * 用户表 Controller
 *
 * @author ljh
 * @date 2019-10-29 11:40:15
 */
@Slf4j
@Validated
@Controller
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "user")
    public String userIndex() {
        return FebsUtil.view("user/user");
    }

    @GetMapping("user")
    @ResponseBody
    public FebsResponse getAllUsers(User user) {
        return new FebsResponse().success().data(userService.findUsers(user));
    }

    @GetMapping("user/list")
    @ResponseBody
    public FebsResponse userList(QueryRequest request, User user) {
        Map<String, Object> dataTable = getDataTable(this.userService.findUsers(request, user));
        return new FebsResponse().success().data(dataTable);
    }

    @PostMapping("user")
    @ResponseBody
    public FebsResponse addUser(@Valid User user) {
        this.userService.createUser(user);
        return new FebsResponse().success();
    }

    @GetMapping("user/delete")
    @ResponseBody
    public FebsResponse deleteUser(User user) {
        this.userService.deleteUser(user);
        return new FebsResponse().success();
    }

    @PostMapping("user/update")
    @ResponseBody
    public FebsResponse updateUser(User user) {
        this.userService.updateUser(user);
        return new FebsResponse().success();
    }

}
