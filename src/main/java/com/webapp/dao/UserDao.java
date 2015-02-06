package com.webapp.dao;

import java.util.List;

import com.webapp.model.User;


public interface UserDao extends BaseDao<User>{
	
	/**
	 * Find All the Users with Same Name
	 * @param name
	 * @return
	 */
	public List<User> findByName(String name);
}
