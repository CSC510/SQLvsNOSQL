package com.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.dao.UserDao;
import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.model.User;

@Component
public class UserService {
	@Resource(name = "userMDBImpl")
	@Autowired
	private UserDao userDao;
	
	public UserService(){
		
	}
	
	public void saveUser(User u){
		userDao.save(u);
	}
	
	public List<User> findUser(String name){
		return userDao.findByName(name);
	}
	
	public void deleteUserByName(String name) {
		List<User> users = userDao.findByName(name);
		for(User user: users) {
			userDao.delete(user);
		}
	}
	
	public void deleteByStudentId(int studentId) {
		Parameter parameter = new Parameter();
		parameter.put("studentId", studentId);
		User u = (User)userDao.findOne(parameter);
		userDao.delete(u);
	}
	
	public void deleteUser(User u) {
		userDao.delete(u);
	}
}
