package com.ljh.demo.system.controller;

import com.ljh.demo.common.controller.BaseController;
import com.ljh.demo.common.entity.DeptTree;
import com.ljh.demo.common.entity.FebsConstant;
import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.common.utils.FebsUtil;
import com.ljh.demo.system.entity.Dept;
import com.ljh.demo.system.service.IDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;


/**
 * 部门表 Controller
 *
 * @author ljh
 * @date 2019-10-30 14:45:19
 */
@Slf4j
@Validated
@Controller
public class DeptController extends BaseController {

    @Autowired
    private IDeptService deptService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "dept")
    public String deptIndex() {
        return FebsUtil.view("dept/dept");
    }

    @GetMapping("dept")
    @ResponseBody
    public FebsResponse getAllDepts() {
        return new FebsResponse().success().data(deptService.findDepts());
    }

    @GetMapping("dept/select/tree")
    @ResponseBody
    public FebsResponse deptList() {
        List<DeptTree<Dept>> deptTree = this.deptService.findDepts();
        return new FebsResponse().success().data(deptTree);
    }

    @GetMapping("dept/tree")
    @ResponseBody
    public FebsResponse getAllMenus(Dept dept) {
        List<DeptTree<Dept>> deptTree = this.deptService.findDeptTree(dept);
        return new FebsResponse().success().data(deptTree);
    }

    @PostMapping("dept")
    @ResponseBody
    public FebsResponse addDept(@Valid Dept dept) {
        this.deptService.createDept(dept);
        return new FebsResponse().success();
    }

    @GetMapping("dept/delete")
    @ResponseBody
    public FebsResponse deleteDept(Dept dept) {
        this.deptService.deleteDept(dept);
        return new FebsResponse().success();
    }

    @PostMapping("dept/update")
    @ResponseBody
    public FebsResponse updateDept(Dept dept) {
        this.deptService.updateDept(dept);
        return new FebsResponse().success();
    }

}
