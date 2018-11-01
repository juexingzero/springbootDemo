package com.demo.service;

import com.demo.model.SysUser;

public interface SysUserService {
	
	//登录用对比用户名，密码
	SysUser loginUser(String userName,String passWord);
}
