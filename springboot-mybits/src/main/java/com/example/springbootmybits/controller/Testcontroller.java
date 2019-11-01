package com.example.springbootmybits.controller;

import com.example.springbootmybits.bean.Student;
import com.example.springbootmybits.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author user
 */
@RestController
public class Testcontroller {

    @Autowired
    private UserSerivce studentService;

    @RequestMapping( value = "/querystudent", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        return this.studentService.queryStudentBySno(sno);
    }
}
