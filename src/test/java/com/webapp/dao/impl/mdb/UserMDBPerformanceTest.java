package com.webapp.dao.impl.mdb;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;

public class UserMDBPerformanceTest extends SpringTransactionContextTest{
	
	@Resource(name = "userMDBImpl")
	private UserMDBImpl userDao;
	public List<String> idsList = new ArrayList<String>();
	
//	@Before
	public void addTestUsers(int times){
		
		for (int i = 0; i < times; i++) {
			User user=new User();
			user.setName(Integer.toString(i));
			userDao.save(user);
			idsList.add(user.getId());
		}
	}

//	@Test
	public void addPerformaceTest(){

		int [] testData={1000,5000,10000,20000,40000,80000,120000,160000,200000};
 		for (int i = 0; i < testData.length; i++) {
			userDao.deleteAll();
			long startTime,totalTime;
			int times=140000;
			startTime=System.currentTimeMillis();
			addTestUsers(times);
			totalTime=System.currentTimeMillis()-startTime;
			System.out.println("MDB add "+times+" pieces of data needs "+totalTime+" ms");
			userDao.deleteAll();
		}
	}
	
	/*
	 *  Find 5000 from different data size in the database
	 */
	@Test
	public void findbyIdPerformance1(){
		userDao.deleteAll();
		int findItems=5000;   // data size in the database
		int[] testData ={5000, 10000, 20000, 40000, 80000, 100000, 150000, 180000, 200000}; // find times
		int times = 10000;  // exchange findItems with testData
		
		addTestUsers(times);
		Random randomGenerator = new Random();
		long startTime,totalTime;
		List<User>resUsers=new ArrayList<User>();
		startTime=System.currentTimeMillis();
		for (int i = 0; i < findItems; i++) {
			int random = randomGenerator.nextInt(times);
			resUsers.add(userDao.findById(idsList.get(random)));
		}
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("MDB find "+times+" records of data by id needs "+totalTime+" ms");
		assertEquals(resUsers.size(), findItems);
		
		idsList.clear();
		userDao.deleteAll();
	}
	
	/*
	 *  Find different data size from 200000
	 */
//	@Test
	public void findbyIdPerformance2(){
		userDao.deleteAll();
		int times=200000;   // data size in the database
		int[] testData ={1000,5000,10000,20000,40000,80000,120000,160000,200000}; // find times
		int findItems = 200000; // exchange findItems with testData
		addTestUsers(times);
		
		Random randomGenerator = new Random();
		long startTime,totalTime;
		List<User>resUsers=new ArrayList<User>();
		startTime=System.currentTimeMillis();
		for (int i = 0; i < findItems; i++) {
			int random = randomGenerator.nextInt(times);
			resUsers.add(userDao.findById(idsList.get(random)));
		}
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("MDB find "+findItems+" records of data by id from " +times+" needs "+totalTime+" ms");
		assertEquals(resUsers.size(), findItems);
		idsList.clear();
		userDao.deleteAll();
	}

	/*
	 *  Delete 5000 from different data size in the database
	 */
//	@Test
	public void deletebyIdPerformance1() {
		userDao.deleteAll();
		int deleteItems=5000;  // random delete times
		int [] testData = {5000,10000,20000,40000,80000,120000,160000,200000};
		int times = 200000;  // exchange times with testData
		long startTime,totalTime;
		addTestUsers(times);
		
		Random randomGenerator = new Random();
		startTime=System.currentTimeMillis();
		for (int j = 0; j < deleteItems; j++) {
			int temp= randomGenerator.nextInt(times);
			userDao.deleteById(idsList.get(temp));
		}
		
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("MDB delete "+deleteItems+" from "+ times+" records of data by id needs "+totalTime+" ms");
		idsList.clear();
		userDao.deleteAll();
	}
	/*
	 *  Delete different size from 200000 in mongodb
	 */
//	@Test
	public void deletebyIdPerformance2() {
		userDao.deleteAll();
		int times = 80000;  
		int [] testData = {1000,5000,10000,20000,40000,80000,120000,160000,200000};
		int deleteItems = 5000;  // exchange deleteItems with testData
		
		addTestUsers(times);
		
		Random randomGenerator = new Random();
		long startTime, totalTime;
		startTime=System.currentTimeMillis();
		for (int i = 0; i < deleteItems; i++) {
			int temp= randomGenerator.nextInt(times);
			userDao.deleteById(idsList.get(temp));
		}
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("MDB delete "+deleteItems+" from "+ times+" records of data by id needs "+totalTime+" ms");
		idsList.clear();
		userDao.deleteAll();
	}
//	@Test
	public void delete() {
		User user = new User();
		user.setName("fred");
		userDao.save(user);
		userDao.deleteById(user.getId());
		userDao.deleteById(user.getId());
		userDao.deleteById(user.getId());
	}
	
}

