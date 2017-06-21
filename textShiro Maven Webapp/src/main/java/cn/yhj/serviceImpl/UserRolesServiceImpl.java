package cn.yhj.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yhj.dao.UserRolesDao;
import cn.yhj.entity.UserRoles;
import cn.yhj.service.UserRolesService;

@Service
public class UserRolesServiceImpl implements UserRolesService {

	@Autowired
	private UserRolesDao userRolesDao;
	
	public List<UserRoles> selectAllRoles(String principal) {
		return userRolesDao.selectAllRoles(principal);
	}

}
