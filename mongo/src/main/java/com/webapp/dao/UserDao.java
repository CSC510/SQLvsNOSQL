package com.webapp.dao;

import java.util.List;

import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.model.User;


public interface UserDao extends BaseDao<User>{
	
	/**
	 * Find All the Users with Same Name
	 * @param name
	 * @return
	 */
	public List<User> findByName(String name);
	/**
     * Find One Entity with Limitation
     * @param parameter
     * @return
     */
	public User findOne( Parameter parameter);
}
