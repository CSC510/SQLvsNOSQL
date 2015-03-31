package com.webapp.dao.impl.sql;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.collect.Lists;
import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.sql.UserSQLImpl;
import com.webapp.model.User;

public class UserSQLPerformanceTest extends SpringTransactionContextTest{
	
	private Logger logger = LoggerFactory.getLogger(UserSQLPerformanceTest.class);
	
	@Resource(name = "userSQLImpl")
	private UserSQLImpl userDao;
	
	private List<User> testUsrs=Lists.newArrayList();
	
	@Before
	public void addUsers(){
		int times =10000;
		for (int i = 0; i < times; i++) {
			User user = new User();
			user.setName("test"+i);
			testUsrs.add(user);
			userDao.save(user);
		}
		
	}

	@Test
	public void add(){
		long startTime,totalTime;
		startTime=System.currentTimeMillis();
		userDao.flush();
		totalTime=System.currentTimeMillis()-startTime;
		logger.info("SQL insert "+testUsrs.size()+" record of data needs "+totalTime+" ms");
	}
	

	@Test
	public void findbyId(){
		long startTime,totalTime;
		
		userDao.flush();
		startTime=System.currentTimeMillis();	
		//find first record
		userDao.findById(testUsrs.get(0).getId());
		totalTime=System.currentTimeMillis()-startTime;
		logger.info("SQL find "+1 +" records out of "+testUsrs.size()+" takes "+totalTime+" ms");
		
	}
	
	@Test
	public void findbyName(){
		long startTime,totalTime;
		userDao.flush();
		startTime=System.currentTimeMillis();
		int resultSize = userDao.findByName("test12").size();
		totalTime=System.currentTimeMillis()-startTime;
		logger.info("SQL find "+resultSize+" records out of "+ testUsrs.size()+" takes "+(totalTime)+"ms");
	
	}
	
	@Test
	public void delete() {		
		long startTime,totalTime;
		int deleteCount = 100;
		userDao.flush();
		for( int i=0; i<  deleteCount ; i++){
			userDao.delete(testUsrs.get(i));
		}
		
		startTime=System.currentTimeMillis();
		userDao.flush();
		totalTime=System.currentTimeMillis()-startTime;
		
		logger.info("SQL delete "+deleteCount+" records out of "+testUsrs.size()+" needs "+totalTime+" ms");
		
	}
}
