package com.webapp.dao.service.mdb;


import java.util.List;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.mongodb.util.JSON;
import com.webapp.common.persistence.Parameter;
import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;
import com.webapp.service.UserService;

public class UserServiceTest extends SpringTransactionContextTest {
	private Logger logger = LoggerFactory.getLogger(UserServiceTest.class); 
	
	@Autowired
	private UserService userService;
	
	@Resource(name ="userMDBImpl")
	private UserMDBImpl userDao;
	
	@Test
	public void NoSqlInjection1(){
		for(int i=0;i<100; i++){
			User u = new User();
			u.setName("test"+i);
			u.setPassword("123456");
			userService.save(u);
		}
		
		
		User input = new User();
		input.setName("test1");
		input.setPassword("123456");
		int count = userService.find(input).size();
		logger.info("Result set "+count);
		assertEquals(count,1);
		
		
		User injection = new User();
		/*the query would be taken as string, so nothing return*/
		injection.setName("test1");
		injection.setPassword("{'$gt': ''}");
	    count = userService.find(injection).size();
		logger.info("Result set "+count);
		assertEquals(count,0);
	}
	
	@Test
	public void NoSQLInjection2(){
	
		Parameter injection = new Parameter();
		/*the query would be taken as a JSONObject, return all records*/
		injection.put("password", JSON.parse("{$gt:''}"));
		
	    int count = userDao.findAll(null,injection).size();
		logger.info("Result set "+count);
		assertEquals(100, count);
		
	}
}
