package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.SysRoleMapper;
import com.demo.model.SysRole;
import com.demo.service.SysRoleService;

import javax.annotation.Resource;

@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Resource
	private SysRoleMapper sysRoleMapper;

	@Override
	public List<SysRole> findRoleByUserId(String userId) {
		
		return sysRoleMapper.findRoleByUserId(userId);
	}

}
