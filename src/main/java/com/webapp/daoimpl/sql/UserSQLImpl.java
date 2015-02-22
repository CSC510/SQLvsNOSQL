package com.webapp.daoimpl.sql;

import java.util.List;

import com.webapp.dao.UserDao;
import com.webapp.model.User;

public class UserSQLImpl extends BaseSQLImpl<User> implements UserDao{

	@Override
	public List<User> findByName(String name) {
		return null;
	}
}
