package com.example.springbootmybits.jpa.service;

import com.example.springbootmybits.jpa.entity.User;

import java.util.List;

public interface UserService {

    List<User> findByConditions(User user);
}
