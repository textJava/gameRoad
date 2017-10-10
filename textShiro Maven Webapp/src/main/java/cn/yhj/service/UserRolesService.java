package cn.yhj.service;

import java.util.List;

import cn.yhj.entity.UserRoles;

public interface UserRolesService {
	public List<UserRoles> selectAllRoles(String principal);
}
