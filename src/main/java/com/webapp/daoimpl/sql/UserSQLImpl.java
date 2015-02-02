package com.webapp.daoimpl.sql;

import com.webapp.dao.UserDao;
import com.webapp.model.User;

public class UserSQLImpl extends BaseSQLImpl<User> implements UserDao{

	@Override
	public User findByName(String name) {
		return null;
	}
	
}
