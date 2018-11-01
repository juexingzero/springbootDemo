package com.demo.service;

import java.util.List;

import com.demo.model.SysRole;

public interface SysRoleService {
	
	//根据用户ID查询角色
	List<SysRole> findRoleByUserId(String userId);
}
