package com.webapp.dao;

import java.util.List;

import com.webapp.model.User;


public interface UserDao extends BaseDao<User>{
	
	public List<User> findByName(String name);
}
