package com.test.dao;

import java.util.List;

import com.test.domain.User;

public interface UserDao {

	User findUser(User user);

	void registerUser(User user);

	List<User> findAllUser();

}
