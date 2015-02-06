package com.webapp.dao.service.mdb;

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
		User u = new User("jiang",256);
		this.userService.saveUser(u);
	}
}
