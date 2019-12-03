package com.ljh.demo.system.controller;

import com.ljh.demo.common.controller.BaseController;
import com.ljh.demo.common.entity.FebsConstant;
import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.common.entity.MenuTree;
import com.ljh.demo.common.exception.FebsException;
import com.ljh.demo.common.utils.FebsUtil;
import com.ljh.demo.system.entity.Menu;
import com.ljh.demo.system.entity.User;
import com.ljh.demo.system.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


/**
 * 菜单表 Controller
 *
 * @author ljh
 * @date 2019-10-30 14:45:19
 */
@Slf4j
@Validated
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {

    @Autowired
    private IMenuService menuService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "menu")
    public String menuIndex() {
        return FebsUtil.view("menu/menu");
    }


    @GetMapping("{username}")
    public FebsResponse getUserMenus(@NotBlank(message = "{required}") @PathVariable String username) throws FebsException {
        User currentUser = getCurrentUser();
        if (!StringUtils.equalsIgnoreCase(username, currentUser.getUsername())) {
            throw new FebsException("您无权获取别人的菜单");
        }
        MenuTree<Menu> userMenus = this.menuService.findUserMenus(username);
        return new FebsResponse().data(userMenus);
    }

    @GetMapping("tree")
    @ResponseBody
    public FebsResponse getAllMenus(Menu menu) {
        MenuTree<Menu> menus = this.menuService.findMenus(menu);
        return new FebsResponse().success().data(menus.getChilds());
    }

    @PostMapping
    @ResponseBody
    public FebsResponse addMenu(@Valid Menu menu) {
        this.menuService.createMenu(menu);
        return new FebsResponse().success();
    }

    @GetMapping("menu/delete")
    @ResponseBody
    public FebsResponse deleteMenu(Menu menu) {
        this.menuService.deleteMenu(menu);
        return new FebsResponse().success();
    }

    @PostMapping("update")
    @ResponseBody
    public FebsResponse updateMenu(Menu menu) {
        this.menuService.updateMenu(menu);
        return new FebsResponse().success();
    }

}
