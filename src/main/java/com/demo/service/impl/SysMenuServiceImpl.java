package com.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.SysMenuMapper;
import com.demo.model.SysMenu;
import com.demo.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override
	public List<SysMenu> findMenuByRoleId(String roleId) {
		List<SysMenu> first = sysMenuMapper.findFisrtSysMenu(roleId);
		for(SysMenu data : first){
			Map<String,String> param = new HashMap<>();
			param.put("menu_parent", data.getMenu_id());
			param.put("role_id", roleId);
			List<SysMenu> second = sysMenuMapper.findSecondSysMenu(param);
			data.setSysMenuList(second);
		}
		return first;
	}

}
