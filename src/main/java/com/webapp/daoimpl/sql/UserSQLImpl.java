package com.webapp.daoimpl.sql;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.webapp.dao.UserDao;
import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.model.User;

@Component
public class UserSQLImpl extends BaseSQLImpl<User> implements UserDao{

	@Override
	public List<User> findByName(String name) {
		return null;
	}

	@Override
	public User findOne(Parameter parameter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(User user){
		this.jdbcTemplate.update("insert into user (name, id) values(?,?)", user.getName(), user.getId());
	}
	@Override
	public void delete(User user){
		String query="delete from user where id='"+user.getId()+"' ";
		jdbcTemplate.update(query);
	}
	@Override
	public void update(User user,String str){
		String query="update user set name= '"+str+"' where id='"+user.getId()+"' ";
		jdbcTemplate.update(query);
	}
	
}
