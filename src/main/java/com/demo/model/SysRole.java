package com.demo.model;

import com.demo.page.util.PageObject;

public class SysRole extends PageObject{
	
	private static final long serialVersionUID = 1L;
	private String role_id;
	private String user_id;
	private String role_name;
	private Integer role_level;
	private Integer state;
	private String create_time;
	private String update_time;
	
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public Integer getRole_level() {
		return role_level;
	}
	public void setRole_level(Integer role_level) {
		this.role_level = role_level;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
