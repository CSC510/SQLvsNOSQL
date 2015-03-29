package com.webapp.dao.impl.mdb;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;

public class UserMDBPerformanceTest extends SpringTransactionContextTest{
	
	@Resource(name = "userMDBImpl")
	private UserMDBImpl userDao;
	private List<String> idsList;
//	@Before
	public void addTestUsers(int times){
		
		for (int i = 0; i < times; i++) {
			User user=new User();
			user.setName(Integer.toString(i));
			userDao.save(user);
//			idsList.add(user.getId());
		}
	}
	

	@Test
	public void addPerformaceTest(){
		int [] testData={1000,10000,20000,30000,60000,90000,100000,
				200000,300000,400000,500000,600000,700000,800000,900000,1000000};
 		for (int i = 0; i <= testData.length; i++) {
			userDao.deleteAll();
			long startTime,totalTime;
			int times=testData[i];
			startTime=System.currentTimeMillis();
//			List<String> ids=new ArrayList<String>();
			addTestUsers(times);
			totalTime=System.currentTimeMillis()-startTime;
			System.out.println("MDB add "+times+" pieces of data needs "+totalTime+" ms");
//			assertEquals(userDao.findAll().size(), times);
			userDao.deleteAll();
		}

	}
//	@Test
	public void findbyIdPerformance(){
		userDao.deleteAll();
		int times=10000;int findNumber=5000;
		long startTime,totalTime;
		String [] randoms=new String [findNumber];
		addTestUsers(times);
		for (int i = 0; i < findNumber; i++) {
			int temp=(int) (Math.random()*times);
			randoms[i]=idsList.get(temp);
		}
		startTime=System.currentTimeMillis();
		List<User>resUsers=new ArrayList<User>();
		for (int i = 0; i < findNumber; i++) {
			resUsers.add(userDao.findById(randoms[i]));
		}
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("MDB find "+findNumber+" records of data by id needs "+totalTime+" ms");
		assertEquals(resUsers.size(), findNumber);
		userDao.deleteAll();
	}

//	@Test
	public void deletebyIdPerformance() {
		userDao.deleteAll();
		int deleteItems=3000;
		int times=10000;
		long startTime,totalTime;
		Set<String>randoms=new HashSet<String>();
		addTestUsers(times);
		while(randoms.size()<deleteItems) {
			int temp=(int) (Math.random()*times);
			randoms.add(idsList.get(temp));
		}
		startTime=System.currentTimeMillis();
		for (int i = 0; i < randoms.size(); i++) {
			userDao.deleteById((String)randoms.toArray()[i]);
		}
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("MDB delete "+deleteItems+" records of data by id needs "+totalTime+" ms");
		assertEquals(userDao.findAll().size(), times-deleteItems);
		userDao.deleteAll();
	}
}
