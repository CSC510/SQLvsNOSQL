package com.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.webapp.dao.UserDao;
import com.webapp.model.User;

@Component
public class UserService {
	@Resource(name = "userMDBImpl")
	private UserDao userDao;
	
	public UserService(){
		
	}
	
	public void addUser(User u){
		userDao.save(u);
	}
	
	public List<User> findUerByName(String name){
		return userDao.findByName(name);
	}
}
