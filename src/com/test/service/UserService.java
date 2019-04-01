package com.test.service;

import com.test.domain.User;

public interface UserService {

	User findUser(User user);

	void registerUser(User user);

}
