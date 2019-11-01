package com.example.springbootmybits.service;

import com.example.springbootmybits.bean.Student;

/**
 * @author ljh
 */
public interface UserSerivce {
    int add(Student student);
    int update(Student student);
    int deleteBySno(String sno);
    Student queryStudentBySno(String sno);
}
