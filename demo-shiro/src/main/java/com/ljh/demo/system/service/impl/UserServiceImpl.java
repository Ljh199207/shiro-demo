package com.ljh.demo.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.system.entity.User;
import com.ljh.demo.system.mapper.UserMapper;
import com.ljh.demo.system.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户表 Service实现
 *
 * @author ljh
 * @date 2019-10-29 11:40:15
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> findUsers(QueryRequest request, User user) {
        Page<User> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, getWrapper(user));
    }

    private Wrapper<User> getWrapper(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(user.getUsername())) {
            queryWrapper.eq(User::getUsername, user.getUsername());
        }
        if(StringUtils.isNotBlank(user.getSex()))
        {
            queryWrapper.eq(User::getSex,user.getSex());
        }
        return queryWrapper;
    }

    @Override
    public List<User> findUsers(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
// TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        this.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
// TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public User findByName(String userName) {
        return this.baseMapper.findByName(userName);
    }
}
