package com.webapp.dao.impl.sql;

import static org.junit.Assert.*;

import java.util.List;

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
	@Test
	public void findByName() {
		User user1 = new User();
		user1.setName("fred");
		user1.setId("1000");
		User user2 = new User();
		user2.setName("fred");
		user2.setId("1001");
		userDao.save(user1);
		userDao.save(user2);
		
		List<User> users = userDao.findByName("fred");
		assertEquals(users.size(), 2);
		userDao.delete(user1);
		userDao.delete(user2);
	}
	@Test
	public void findAll() {
		User user1 = new User();
		user1.setName("fred");
		user1.setId("1000");
		User user2 = new User();
		user2.setName("fred");
		user2.setId("1001");
		userDao.save(user1);
		userDao.save(user2);
		
		List<User> users = userDao.findAll();
		assertEquals(users.size(), 2);
		userDao.delete(user1);
		userDao.delete(user2);
	}
}
