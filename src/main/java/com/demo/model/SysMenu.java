package com.demo.model;


import java.util.List;

import com.demo.page.util.PageObject;

public class SysMenu extends PageObject{

	private static final long serialVersionUID = 1L;
	private String menu_id;
	private String role_id;
	private String menu_name;
	private String menu_parent;
	private Integer menu_level;
	private String menu_address;
	private String remark;
	private List<SysMenu> SysMenuList;
	
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_parent() {
		return menu_parent;
	}
	public void setMenu_parent(String menu_parent) {
		this.menu_parent = menu_parent;
	}
	public Integer getMenu_level() {
		return menu_level;
	}
	public void setMenu_level(Integer menu_level) {
		this.menu_level = menu_level;
	}
	public String getMenu_address() {
		return menu_address;
	}
	public void setMenu_address(String menu_address) {
		this.menu_address = menu_address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<SysMenu> getSysMenuList() {
		return SysMenuList;
	}
	public void setSysMenuList(List<SysMenu> sysMenuList) {
		SysMenuList = sysMenuList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
