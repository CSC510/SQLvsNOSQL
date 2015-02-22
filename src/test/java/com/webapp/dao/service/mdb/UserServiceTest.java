package com.webapp.dao.service.mdb;


import java.util.List;
import static org.junit.Assert.assertEquals;
import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.User;
import com.webapp.service.UserService;

public class UserServiceTest extends SpringTransactionContextTest {
	
	@Resource
	private UserService userService;
	
	@Test
	public void saveUser(){
		User u1 = new User("fred",256);
		User u2 = new User("fred",257);
		userService.saveUser(u1);
		userService.saveUser(u2);
		
		List<User> users = userService.findUserByName("fred");
		
		for(User user: users) {
			userService.deleteUser(user);
		}
	}
	
	@Test
	public void findByStudentId() {
		User u1 = new User("fred",98);
		userService.saveUser(u1);
		User user = userService.findUserByStudentId(98);
		assertEquals(user.getName(), "fred");
		userService.deleteByStudentId(98);
	}
	
	@Test
	public void deleteUserByName() {
		User u1 = new User("maxlpy", 99);
		userService.saveUser(u1);
		userService.deleteUserByName("maxlpy");
	}
	
	@Test
	public void deleteUserByStudentId() {
		User u1 = new User("maxlpy", 100);
		userService.saveUser(u1);
		userService.deleteByStudentId(100);
	}
}
