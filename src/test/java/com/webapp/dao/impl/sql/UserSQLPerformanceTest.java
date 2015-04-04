package com.webapp.dao.impl.sql;


import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

import com.google.common.collect.Lists;
import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.sql.UserSQLImpl;
import com.webapp.model.User;

public class UserSQLPerformanceTest extends SpringTransactionContextTest{
	
	private Logger logger = LoggerFactory.getLogger(UserSQLPerformanceTest.class);
	
	@Resource(name = "userSQLImpl")
	private UserSQLImpl userDao;
	
	private List<User> testUsrs=Lists.newArrayList();
	
//	@Before
	public void addUsers(int times){
//		int times =10000;
		for (int i = 0; i < times; i++) {
			User user = new User();
			user.setName("test"+i);
			userDao.save(user);
			testUsrs.add(user);
		}
	}
	
	

//	@Test
	public void add(){
		int [] testData={1000,100000,200000,300000,400000,500000,600000,700000,800000,900000,1000000};
		for (int i = 0; i < testData.length; i++) {
			long startTime,totalTime;
			startTime=System.currentTimeMillis();
			addUsers(testData[i]);
			totalTime=System.currentTimeMillis()-startTime;
			userDao.flush();
			logger.info("SQL insert "+testData[i]+" record of data needs "+totalTime+" ms");
		}
	}
	

	@Test
	public void findbyId(){
		int times = 1000000;   // data size in the database
		int[] testData ={1000,100000,200000,300000,400000,500000,600000,700000,800000,900000,1000000}; // find times
		addUsers(times);
		userDao.flush();
//		for (int i = 0; i < testData.length; i++) {
//			Random randomGenerator = new Random();
//			long startTime,totalTime;
//			
//			userDao.flush();
//			startTime=System.currentTimeMillis();	
//			for (int j = 0; j < testData[i]; j++) {
//				int randomNum = randomGenerator.nextInt(times);  // generate a random number from 0 to times number.
//				userDao.findById(testUsrs.get(randomNum).getId());
//			}
//			totalTime=System.currentTimeMillis()-startTime;
//			logger.info("SQL find "+testData[i] +" records out of "+testUsrs.size()+" takes "+totalTime+" ms");
//		}
	}
	
//	@Test
	public void delete() {	
//		int times = 1000000;   // data size in the database
		int deleteItems=30000;  // random delete times
		int [] testData = {50000,100000,200000,300000,400000,500000,600000,700000,800000,900000,1000000};
		for (int i = 0; i < testData.length; i++) {
			int deleteCount = testData[i];  // find times
			int times = testData[i]; // data size in the database
			addUsers(times);
			
			Set<User>randoms=new HashSet<User>();
			Random randomGenerator = new Random();
			while(randoms.size()<deleteItems) {
				int temp= randomGenerator.nextInt(testData[i]);
				randoms.add(testUsrs.get(temp));
			}
			
			long startTime,totalTime;
			userDao.flush();
			for (int j = 0; j < randoms.size(); j++) {
				userDao.delete((User)randoms.toArray()[j]);
			}
			
			startTime=System.currentTimeMillis();
			userDao.flush();
			totalTime=System.currentTimeMillis()-startTime;
	
			logger.info("SQL delete "+deleteCount+" records out of "+testUsrs.size()+" needs "+totalTime+" ms");
		}
		
	}
}
