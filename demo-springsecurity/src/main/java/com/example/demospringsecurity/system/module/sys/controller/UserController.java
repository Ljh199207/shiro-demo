package com.example.demospringsecurity.system.module.sys.controller;

import com.example.demospringsecurity.system.module.sys.service.UserService;
import com.example.demospringsecurity.system.module.sys.service.dto.UserQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljh
 * @date 2019-11-22 09:00
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity hello(UserQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(userService.queryAll(criteria, pageable), HttpStatus.OK);
    }

}
