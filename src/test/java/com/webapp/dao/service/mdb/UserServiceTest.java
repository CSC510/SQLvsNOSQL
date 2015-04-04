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
	public void save(){
		User u1 = new User();
		u1.setName("hongyi");
		
		User u2 = new User();
		u2.setName("hongyi2");
		userService.save(u1);
		userService.save(u2);
		commit();
		
		userService.find(u1);
		userService.delete(u2);
		commit();
		
	}
}
