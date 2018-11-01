package com.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.demo.model.SysUser;

@Mapper
public interface SysUserMapper {

	SysUser loginUser(Map<?, ?> UserMap);
	
	
}
