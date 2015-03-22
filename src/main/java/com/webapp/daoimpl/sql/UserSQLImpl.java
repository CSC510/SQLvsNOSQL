package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.UserDao;
import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.model.User;

@Component
public class UserSQLImpl extends BaseSQLImpl<User> implements UserDao{

	@Override
	public List<User> findByName(String name) {
		return findBySql("select * from  user where name like '%"+name+"%'");
	}

	
	

}
