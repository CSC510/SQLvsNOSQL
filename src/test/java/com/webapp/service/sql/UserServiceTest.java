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
	public void NosqlInjection(){
		for(int i=0;i<100; i++){
			User u = new User();
			u.setName("test"+i);
			userService.save(u);
		}
		commit();
		User u = new User();
		u.setName("test1");
		int count = userService.find(u).size();
		logger.info("Result set "+count);
		assertEquals(count,1);
		
		
		User uInjection = new User();
		/* the query code would be select * from user where name='test1' or '1' ,which is always true and return all the records*/
		uInjection.setName("test1' OR '1");
	    count = userService.find(uInjection).size();
		logger.info("Result set "+count);
		assertEquals(count,100);
	}
}
