package com.webapp.daoimpl.mdb;

import com.webapp.dao.UserDao;
import com.webapp.model.User;

public class UserMDBImpl extends BaseMDBImpl<User> implements UserDao{

	@Override
	public User findByName(String name) {
		return null;
	}
}
