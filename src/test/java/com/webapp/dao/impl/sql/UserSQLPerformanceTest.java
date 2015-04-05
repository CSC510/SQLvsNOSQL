package com.webapp.dao.impl.sql;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		testUsrs.clear();
		for (int i = 0; i < times; i++) {
			User user = new User();
			user.setName("test" + i);
			testUsrs.add(user);
			userDao.save(user);
		}
	}
//	@Test
	@Rollback(false)
	public void addTest() {
		addUsers(200000);
		System.out.println(testUsrs.size());
		System.out.println("Success~~~~~~~~~~~~~~~~~~");
	}

	
//	@Test
	@Rollback(true)
	public void addPerformance(){
//		int [] testData={1000,5000,10000,20000,40000,80000,120000,160000,200000};
		int [] testData={400000};
		for (int i = 0; i < testData.length; i++) {
			long startTime,totalTime;
			addUsers(testData[i]);
			startTime=System.currentTimeMillis();
			userDao.flush();
			totalTime=System.currentTimeMillis()-startTime;
			logger.info("SQL insert "+testData[i]+" record of data needs "+totalTime+" ms");
		}
	}
	/*
	 *  Find 5000 from different data size in the database
	 */
//	@Test 
	@Rollback(true)
	public void findByIdPerformance1() {
		int findItems = 5000;
		int[] testData ={5000, 10000, 20000, 40000, 80000, 120000, 160000, 200000}; // find times
		int times = 200000; // exchange times with testData
		addUsers(times);
		userDao.flush();

		long startTime,totalTime;
		startTime=System.currentTimeMillis();
		for (int k = 0; k < findItems; k++) {
			Random randomGenerator = new Random();
			int random = randomGenerator.nextInt(times);
			userDao.findById(testUsrs.get(random).getId());
		}
		totalTime=System.currentTimeMillis()-startTime;
		logger.info("SQL find "+findItems +" records out of "+times+" takes "+totalTime+" ms");
		testUsrs.clear();
	}

	/*
	 *  Find different data size from 200000
	 */
	@Test
	@Rollback(true)
	public void findbyIdPerformance2() { 
		int times = 200000;   // data size in the database
		int[] testData ={1000, 5000, 10000, 20000, 40000, 80000, 100000, 150000, 180000, 200000}; // find times
		int findItems = 1000; // exchange findItems with testData
		
		addUsers(times);
		userDao.flush();
		Random randomGenerator = new Random();
		long startTime,totalTime;
		
		startTime=System.currentTimeMillis();	
		for (int j = 0; j < findItems; j++) {
			int randomNum = randomGenerator.nextInt(times);  // generate a random number from 0 to times number.
			userDao.findById(testUsrs.get(randomNum).getId());
		}
		totalTime=System.currentTimeMillis()-startTime;
		logger.info("SQL find "+findItems +" records out of "+testUsrs.size()+" takes "+totalTime+" ms");
		testUsrs.clear();
	}
	
	/*
	 *  Delete 5000 from different data size in the database
	 */
//	@Test
	public void deletePerformance1() {	
		int deleteItems=5000;  // random delete times
		int [] testData = {5000,10000,20000,40000,80000,120000,160000,200000};
		int times = 5000;  // exchange times with testData
		
		addUsers(times);
		userDao.flush();
		
		Set<User>randoms=new HashSet<User>();
		Random randomGenerator = new Random();
		while(randoms.size() < deleteItems) {
			int temp= randomGenerator.nextInt(times);
			randoms.add(testUsrs.get(temp));
		}
//		Iterator items = randoms.iterator();
//		while(items.hasNext()) {
//			User user = (User) items.next();
//			userDao.deleteById(user.getId());
//		}

		long startTime,totalTime;
		for (int j = 0; j < randoms.size(); j++) {
			userDao.delete((User)randoms.toArray()[j]);
		}
		
		startTime=System.currentTimeMillis();
		userDao.flush();
		totalTime=System.currentTimeMillis()-startTime;
		logger.info("SQL delete "+deleteItems+" records out of "+testUsrs.size()+" needs "+totalTime+" ms");
		randoms.clear();
		testUsrs.clear();
	}
	/*
	 *  Delete different data size from 200000 in the mysql database
	 */
//	@Test
	public void deletePerformance2() {
		int times = 200000;   // data size in the database
		int[] testData ={1000, 5000, 10000, 20000, 40000, 80000, 100000, 150000, 180000, 200000}; // find times
		int deleteItems = 1000; // exchange deleteItems with testData
		
		addUsers(times);
		userDao.flush();
		Set<User>randoms=new HashSet<User>();
		Random randomGenerator = new Random();
		while (randoms.size() < deleteItems) {
			int temp = randomGenerator.nextInt(times);
			randoms.add(testUsrs.get(temp));
		}
		for (int i = 0; i < randoms.size(); i++) {
			userDao.delete((User)randoms.toArray()[i]);
		}
		long startTime, totalTime;
		startTime = System.currentTimeMillis();
		userDao.flush();
		totalTime = System.currentTimeMillis() - startTime;
		logger.info("SQL delete "+deleteItems+" records out of "+testUsrs.size()+" needs "+totalTime+" ms");
		randoms.clear();
		testUsrs.clear();
	}


//	@Test
	public void add(){
		long startTime,totalTime;
		startTime=System.currentTimeMillis();
		userDao.flush();
		totalTime=System.currentTimeMillis()-startTime;
		logger.info("SQL insert "+testUsrs.size()+" record of data needs "+totalTime+" ms");
	}
	

//	@Test
	public void findbyId(){
		long startTime,totalTime;
		
		userDao.flush();
		startTime=System.currentTimeMillis();	
		//find first record
		userDao.findById(testUsrs.get(0).getId());
		totalTime=System.currentTimeMillis()-startTime;
		logger.info("SQL find "+1 +" records out of "+testUsrs.size()+" takes "+totalTime+" ms");
		
	}
	
//	@Test
	public void findbyName(){
		long startTime,totalTime;
		userDao.flush();
		startTime=System.currentTimeMillis();
		int resultSize = userDao.findByName("test12").size();
		totalTime=System.currentTimeMillis()-startTime;
		logger.info("SQL find "+resultSize+" records out of "+ testUsrs.size()+" takes "+(totalTime)+"ms");
	
	}
	
//	@Test
	public void deletePerformance() {		
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
