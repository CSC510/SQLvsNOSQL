package com.webapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.webapp.model.User;

public interface UserDao {
	public User findByName(String name);
}
