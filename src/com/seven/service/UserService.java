package com.seven.service;
import com.seven.dao.UserDao;
import com.seven.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

	public boolean addUser(User user){
		if (checkUserNameIsExit(user.getUserName())){
			return false;
		}else
			userDao.addUser(user);
		return true;
	}

	public boolean checkUserNameIsExit(String userName) {
		User user=userDao.checkUserNameIsExit(userName);
		if (user!=null) return true;
		return false;
	}
}
