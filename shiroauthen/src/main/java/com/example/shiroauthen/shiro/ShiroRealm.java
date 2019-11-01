package com.example.shiroauthen.shiro;

import com.example.shiroauthen.dao.UserMapper;
import com.example.shiroauthen.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm  extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;
    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName  = (String) token.getPrincipal();
        String passWord = new String((char[]) token.getCredentials());
        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        // 通过用户名到数据库查询用户信息
        User user = userMapper.findByUserName(userName);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!passWord.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, passWord, getName());
        return info;

    }
}
