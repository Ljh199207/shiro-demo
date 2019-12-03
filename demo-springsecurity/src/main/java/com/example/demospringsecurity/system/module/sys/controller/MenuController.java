package com.example.demospringsecurity.system.module.sys.controller;

import com.example.demospringsecurity.system.module.sys.service.MenuService;
import com.example.demospringsecurity.system.module.sys.service.RoleService;
import com.example.demospringsecurity.system.module.sys.service.UserService;
import com.example.demospringsecurity.system.module.sys.service.dto.MenuDTO;
import com.example.demospringsecurity.system.module.sys.service.dto.UserDTO;
import com.example.demospringsecurity.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljh
 * @date 2019-11-27 15:35
 */
@Api(tags = "系统：菜单管理")
@RestController
@RequestMapping("/api/menus")
@SuppressWarnings("unchecked")
public class MenuController {

    private final MenuService menuService;

    private final UserService userService;

    private final RoleService roleService;

    private static final String ENTITY_NAME = "menu";


    public MenuController(MenuService menuService, UserService userService, RoleService roleService) {
        this.menuService = menuService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @ApiOperation("获取前端所需菜单")
    @GetMapping(value = "/build")
    public ResponseEntity buildMenu() {
        UserDTO user = userService.findByName(SecurityUtils.getUsername());
        List<MenuDTO> menuDTOList = menuService.findByRoles(roleService.findByUsers_Id(user.getId()));
        List<MenuDTO> menuDTOS = (List<MenuDTO>) menuService.buildTree(menuDTOList).get("content");
        return new ResponseEntity<>(menuService.buildMenus(menuDTOS), HttpStatus.OK);
    }
}
