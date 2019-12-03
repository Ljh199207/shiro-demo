package com.ljh.demo.system.controller;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.ljh.demo.common.controller.BaseController;
import com.ljh.demo.common.entity.FebsConstant;
import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.common.utils.ExcelUtil;
import com.ljh.demo.common.utils.FebsUtil;
import com.ljh.demo.system.entity.User;
import com.ljh.demo.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;
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

    @GetMapping("user/check/{username}")
    @ResponseBody
    public boolean checkUserName(@NotBlank(message = "{required}") @PathVariable String username, String userId) {
        boolean b = this.userService.findByName(username) == null || StringUtils.isNotBlank(userId);
        return b;
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

    @GetMapping("user/excel")
    @RequiresPermissions("user:export")
    public void export(QueryRequest queryRequest, User user, HttpServletResponse response) throws IOException {
        List<User> users = this.userService.findUserDetail(user, queryRequest).getRecords();
        ExcelUtil.down(new ExportParams("用户信息", "用户信息"), User.class, users, response);
    }


}
