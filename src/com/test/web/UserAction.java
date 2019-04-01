package com.test.web;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.domain.User;
import com.test.service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String loginUser(User user,HttpSession session,HttpServletResponse response){
		User u = userService.findUser(user);
		if (u != null) {
			session.setAttribute("user", u);
			return "customer/index";
		} else {
			return "customer/false";
		}
	}
	@RequestMapping("/register")
	public String registerUser(User user){
		String uid = UUID.randomUUID().toString();
		user.setUid(uid);
		userService.registerUser(user);
		return "login.htm";
	}
}
