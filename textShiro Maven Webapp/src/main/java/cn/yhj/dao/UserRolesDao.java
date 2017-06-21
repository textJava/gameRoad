package cn.yhj.dao;

import java.util.List;

import cn.yhj.entity.UserRoles;

public interface UserRolesDao {

	public List<UserRoles> selectAllRoles(String principal);
	
}
