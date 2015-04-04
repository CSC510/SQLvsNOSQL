package com.webapp.service.sql;


import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.User;
import com.webapp.service.UserService;

public class UserServiceTest extends SpringTransactionContextTest{
	
	private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	@Autowired
	private UserService userService;
	@Test
	public void sqlInjection(){
		for(int i=0;i<100; i++){
			User u = new User();
			u.setName("test"+i);
			u.setPassword("123456");
			userService.save(u);
		}
		
		commit();
		
		User u = new User();
		u.setName("test1");
		u.setPassword("123456");
		int count = userService.find(u).size();
		logger.info("Result set "+count);
		assertEquals(count,1);
		
		
		User uInjection = new User();
		/*the query would be taken as a object, so nothing return*/
		uInjection.setName("test1' OR '1");
		uInjection.setPassword("123456");
	    count = userService.find(uInjection).size();
		logger.info("Result set "+count);
		assertEquals(count,0);
		
		User injection = new User();
		/*the query would be taken as a object, so nothing return*/
		injection.setName("{'$gt': ''}");
		injection.setPassword("123456");
	    count = userService.find(injection).size();
		logger.info("Result set "+count);
		assertEquals(count,0);
	}
}
