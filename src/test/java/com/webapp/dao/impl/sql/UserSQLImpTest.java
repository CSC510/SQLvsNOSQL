package com.webapp.dao.impl.sql;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.UserDao;
import com.webapp.daoimpl.sql.UserSQLImpl;
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
		user.setId("235342");
		userDao.save(user);
		userDao.delete(user);
//		userDao.deleteById(user.getId());
	}
	
	@Test
	public void update(){
		User user=new User();
		user.setName("jesse");
		user.setId("210001");
		userDao.save(user);
		userDao.updateName(user,"tom");
		userDao.delete(user);
		
	}
	@Test 
	public void find(){
		User user=new User();
		user.setName("jess");
		user.setId("210002");
		userDao.save(user);
		User newUser=userDao.findById("210002");
		if (user!=null) {
			System.out.println(user.getName());
		}
		userDao.delete(user);
		
	}

	
}
