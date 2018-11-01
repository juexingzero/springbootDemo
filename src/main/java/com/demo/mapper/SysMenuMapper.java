package com.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.demo.model.SysMenu;

@Mapper
public interface SysMenuMapper {

	//查询1级菜单
	List<SysMenu> findFisrtSysMenu(String roleId);
	
	//查询对应2级菜单
	List<SysMenu> findSecondSysMenu(Map menu_para);
}
