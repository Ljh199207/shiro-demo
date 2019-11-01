package com.example.springbootmybits.service.impl;

import com.example.springbootmybits.bean.Student;
import com.example.springbootmybits.mapper.UserMapper;
import com.example.springbootmybits.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author user
 */
@Service("studentService")
public class UserServiceImpl implements UserSerivce {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(Student student) {
        return this.userMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return this.userMapper.update(student);
    }

    @Override
    public int deleteBySno(String sno) {
        return this.userMapper.deleteBySno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.userMapper.queryStudentBySno(sno);
    }
}
