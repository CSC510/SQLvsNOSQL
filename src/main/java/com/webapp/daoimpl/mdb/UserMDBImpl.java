package com.webapp.daoimpl.mdb;

import java.util.List;





import org.springframework.stereotype.Component;

import com.webapp.dao.UserDao;
import com.webapp.model.User;


@Component
public class UserMDBImpl extends BaseMDBImpl<User> implements UserDao{

	@Override
	public List<User> findByName(String name) {
		return findAll("{name:"+name+"}");
	}

	
	
}
