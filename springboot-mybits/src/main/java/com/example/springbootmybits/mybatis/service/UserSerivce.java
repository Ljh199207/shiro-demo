package com.example.springbootmybits.mybatis.service;

import com.example.springbootmybits.mybatis.bean.Student;

/**
 * @author ljh
 */
public interface UserSerivce {
    int add(Student student);
    int update(Student student);
    int deleteBySno(String sno);
    Student queryStudentBySno(String sno);
}
