package com.webapp.dao;

import com.webapp.model.User;


public interface UserDao extends BaseDao<User>{
	public User findByName(String name);
}
