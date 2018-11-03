package com.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.mapper.SysMenuMapper;
import com.demo.model.SysMenu;
import com.demo.service.SysMenuService;

import javax.annotation.Resource;

@Service
@CacheConfig(cacheNames = "menu")
public class SysMenuServiceImpl implements SysMenuService {
	
	@Resource
	private SysMenuMapper sysMenuMapper;

	@Override
	@Cacheable("menulist")
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
