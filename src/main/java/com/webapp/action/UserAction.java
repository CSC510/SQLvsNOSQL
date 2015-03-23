package com.webapp.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.webapp.model.User;
import com.webapp.service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	
	
	
	public List<User> find(User user) {
		return userService.find( user);
	}
	
	public void save(User user) {
		userService.save(user);
	}
	
	public void delete(User user) {
		userService.delete(user);
	}
}
