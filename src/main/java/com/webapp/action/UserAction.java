package com.webapp.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.webapp.model.User;
import com.webapp.service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	
	public void addUser(User u) {
		userService.saveUser(u);
	}
	
	public User findByStudentId(int studentId) {
		return userService.findUserByStudentId(studentId);
	}
	
	public void deleteByStudentId(int studentId) {
		userService.deleteByStudentId(studentId);
	}
	
	public void deleteByStudentName(String name) {
		userService.deleteUserByName(name);
	}
}
