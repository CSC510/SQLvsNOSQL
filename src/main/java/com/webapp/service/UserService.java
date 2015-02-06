package com.webapp.service;

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
	
	public void saveUser(User u){
		userDao.save(u);
	}
}
