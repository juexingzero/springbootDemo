package com.demo.service;

import java.util.List;

import com.demo.model.SysMenu;

public interface SysMenuService {

	List<SysMenu> findMenuByRoleId(String roleId);
}
