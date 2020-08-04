package com.ljh.demo.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.demo.common.authentication.ShiroRealm;
import com.ljh.demo.common.entity.FebsConstant;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.common.utils.FebsUtil;
import com.ljh.demo.common.utils.SortUtil;
import com.ljh.demo.system.entity.User;
import com.ljh.demo.system.entity.UserRole;
import com.ljh.demo.system.mapper.UserMapper;
import com.ljh.demo.system.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    @Autowired
    private UserRoleServiceImpl userRoleService;
    @Autowired
    private ShiroRealm shiroRealm;

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
        if (StringUtils.isNotBlank(user.getSex())) {
            queryWrapper.eq(User::getSex, user.getSex());
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
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(User user) {
        this.saveOrUpdate(user);
        userRoleService.remove(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, user.getId()));
        String[] roles = user.getRoleId().split(StringPool.COMMA);
        setUserRoles(user, roles);
    }

    private void setUserRoles(User user, String[] roles) {
        List<UserRole> userRoles = new ArrayList<>();
        Arrays.stream(roles).forEach(roleId -> {
            UserRole ur = new UserRole();
            ur.setUserId(user.getUserId());
            ur.setRoleId(Long.valueOf(roleId));
            userRoles.add(ur);
        });
        userRoleService.saveBatch(userRoles);
        User currentUser = FebsUtil.getCurrentUser();
        if (StringUtils.equalsIgnoreCase(currentUser.getUsername(), user.getUsername())) {
            shiroRealm.clearCache();
        }
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateLoginTime(String username) {
        User user = new User();
        user.setLastLoginTime(new Date());
        baseMapper.update(user, new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }

    @Override
    public IPage<User> findUserDetail(User user, QueryRequest request) {
        Page<User> page = new Page<>(request.getPageNum(), request.getPageSize());
        SortUtil.handlePageSort(request, page, "userId", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findUserDetailPage(page, user);
    }
}
