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
		return null;
	}

	@Override
	public User findOne(Parameter parameter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(User user){
		this.jdbcTemplate.update("insert into user (id,name) values(?,?)", user.getId(), user.getName());
	}
	@Override
	public void delete(User user){
		String query="delete from user where id="+user.getId();
		jdbcTemplate.update(query);
	}
	@Override
	public void updateName(User user,String str){
		String query="update user set name= '"+str+"' where id='"+user.getId()+"' ";
		jdbcTemplate.update(query);
	}
	@Override
	public User findById (Serializable id){
		String sql = "SELECT * FROM user WHERE id = ?";
		User user = jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
		return user;
	}
}
