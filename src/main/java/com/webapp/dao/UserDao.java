package com.webapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.webapp.model.User;

public interface UserDao {
	public List<User> findByName(String name);
}
