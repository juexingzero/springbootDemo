package com.demo.shiro;

import com.demo.model.SysUser;
import com.demo.service.SysUserService;
import com.demo.util.AppUtil;
import com.demo.util.MD5Util;
import com.demo.model.SysUser;
import com.demo.service.SysUserService;
import com.demo.util.AppUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author 陈智颖
 * @create 2018-07-31 下午3:38
 **/
public class CustomRealm extends AuthorizingRealm {

    // 系统用户类
    @Resource
    private SysUserService sysUserService;

    //告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
    {
        //设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
        hashMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashMatcher.setHashIterations(1);// 散列的次数，比如散列两次，相当于md5(md5(""));
        this.setCredentialsMatcher(hashMatcher);
    }


    //定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        Object principal = SecurityUtils.getSubject().getPrincipal();
        Map<String, Object> user = AppUtil.objectToMap(principal);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles((Set<String>) user.get("roles"));
        info.setStringPermissions((Set<String>) user.get("perms"));
        return info;
    }

    //定义如何获取用户信息的业务逻辑，给shiro做登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String account = upToken.getUsername();
        String password = String.valueOf(upToken.getPassword());

        // Null username is invalid
        if (account == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        SysUser userDB = sysUserService.loginUser(account, MD5Util.GetMD5Code(password));
        //userDB.setAuthCacheKey(AppUtil.getUUID());


        /*
        // 职位or角色
        userDB.getRoles().addAll(roles);
        // 权限sys:xxx
        userDB.getPerms().addAll(perms);
        */

        if (userDB == null) {
            throw new UnknownAccountException("No account found for admin [" + account + "]");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDB, userDB.getPass_word(), getName());

        return info;
    }

}
