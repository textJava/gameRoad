package cn.yhj.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yhj.dao.UserLoginDao;
import cn.yhj.entity.UserLogin;
import cn.yhj.service.UserLoginService;
@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserLoginDao userLoginDao;
	
	public UserLogin selectUser(UserLogin userLogin) {
		return userLoginDao.selectUser(userLogin);
	}

}
