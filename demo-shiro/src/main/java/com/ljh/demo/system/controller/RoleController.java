package com.ljh.demo.system.controller;

import com.ljh.demo.common.controller.BaseController;
import com.ljh.demo.common.entity.FebsConstant;
import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.common.utils.FebsUtil;
import com.ljh.demo.system.entity.Role;
import com.ljh.demo.system.service.IRoleService;
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
 * 角色表 Controller
 *
 * @author ljh
 * @date 2019-10-30 14:45:19
 */
@Slf4j
@Validated
@Controller
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "role")
    public String roleIndex() {
        return FebsUtil.view("role/role");
    }

    @GetMapping("role")
    @ResponseBody
    public FebsResponse getAllRoles(Role role) {
        return new FebsResponse().success().data(roleService.findRoles(role));
    }

    @GetMapping("role/list")
    @ResponseBody
    public FebsResponse roleList(QueryRequest request, Role role) {
        Map<String, Object> dataTable = getDataTable(this.roleService.findRoles(request, role));
        return new FebsResponse().success().data(dataTable);
    }

    @PostMapping("role")
    @ResponseBody
    public FebsResponse addRole(@Valid Role role) {
        this.roleService.createRole(role);
        return new FebsResponse().success();
    }

    @GetMapping("role/delete")
    @ResponseBody
    public FebsResponse deleteRole(Role role) {
        this.roleService.deleteRole(role);
        return new FebsResponse().success();
    }

    @PostMapping("role/update")
    @ResponseBody
    public FebsResponse updateRole(Role role) {
        this.roleService.updateRole(role);
        return new FebsResponse().success();
    }

}
