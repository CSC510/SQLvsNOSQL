package com.webapp.daoimpl.mdb;

import java.util.List;




import org.springframework.stereotype.Component;

import com.webapp.dao.UserDao;
import com.webapp.model.User;


@Component
public class UserMDBImpl extends BaseMDBImpl<User> implements UserDao{

	
	public List<User> findByName(String name) {
		Parameter parameter = new Parameter();
		parameter.put("name", name);
		return findAll(parameter);
	}

	@Override
	public void update(User user, String str) {
		// TODO Auto-generated method stub
	}
}
