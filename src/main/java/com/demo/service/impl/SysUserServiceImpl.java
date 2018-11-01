package com.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.SysUserMapper;
import com.demo.model.SysUser;
import com.demo.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser loginUser(String userName, String passWord) {
		Map<String,String> UserMap = new HashMap<String,String>();
		UserMap.put("user_name", userName);
		UserMap.put("pass_word", passWord);
		return sysUserMapper.loginUser(UserMap);
	}

}
