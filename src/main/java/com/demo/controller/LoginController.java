package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.SysMenu;
import com.demo.model.SysRole;
import com.demo.model.SysUser;
import com.demo.service.SysMenuService;
import com.demo.service.SysRoleService;
import com.demo.service.SysUserService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@Autowired
	private SysMenuService sysMenuService;

	@RequestMapping("/loginPage")
	public String tologin() {
		return "login"; 
	}
	
	
	@RequestMapping("/login")
	public String login(String userName,String passWord,HttpServletRequest request) {
		SysUser data = sysUserService.loginUser(userName, passWord);
		if(data != null){
			//将用户存入session中
			HttpSession session = request.getSession(); 
			session.setAttribute("user", data);
			SysRole role = new SysRole();
			List<SysMenu> menus = new ArrayList<>();
			//登录成功,读取角色
			List<SysRole> roleList = sysRoleService.findRoleByUserId(data.getUser_id());
			//暂时一个用户只有一个角色。。
			if(roleList != null && roleList.size() >0){
				role = roleList.get(0);
				session.setAttribute("role", role);
				menus = sysMenuService.findMenuByRoleId(role.getRole_id());
			}
			request.setAttribute("userName", data.getUser_name());
			request.setAttribute("role", role);
			request.setAttribute("menus", menus);
			return "main"; 
		}else{
			//登录失败
			request.setAttribute("error", "账号密码错误");
			return "login";
		}
	}
}
