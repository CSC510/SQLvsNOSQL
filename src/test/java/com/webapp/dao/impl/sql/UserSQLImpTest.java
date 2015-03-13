package com.webapp.dao.impl.sql;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.UserDao;
import com.webapp.model.User;

public class UserSQLImpTest extends SpringTransactionContextTest {
	
	@Resource(name="userSQLImpl")
	private UserDao userDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void save(){
		User user = new User();
		user.setName("jaing");
		userDao.save(user);
		User user2=userDao.findByQuery("select * from user where name='jaing'");
		userDao.delete(user2);
	}
	
	@Test
	public void update(){
		User user=new User();
		user.setName("jesse");
		userDao.save(user);
		User user2=userDao.findByQuery("select * from user where name='jesse'");
		userDao.updateName(user2,"tom");
		userDao.delete(user2);
		
	}
}
