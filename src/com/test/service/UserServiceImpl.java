package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.dao.UserDao;
import com.test.domain.User;

@Controller
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public User findUser(User user) {
		User u = userDao.findUser(user);
		return u;
	}

	@Override
	public void registerUser(User user) {
		userDao.registerUser(user);
	}
}
