package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.model.SysRole;

@Mapper
public interface SysRoleMapper {
	
	List<SysRole> findRoleByUserId(String userId);
}
