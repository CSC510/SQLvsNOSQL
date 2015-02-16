package com.webapp.dao.impl.mdb;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.cassandra.thrift.Cassandra.system_add_column_family_args;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;

public class UserMDBPerformanceTest extends SpringTransactionContextTest{
	
	@Resource(name = "userMDBImpl")
	private UserMDBImpl userDao;
	public void addTestUsers(int times){
		for (int i = 0; i < times; i++) {
			User user=new User(Integer.toString(i),i);
			userDao.save(user);
		}
	}
	

	@Test
	public void addPerformaceTest(){
		userDao.deleteAll();
		int threadCount=5;
		long startTime,totalTime;
		int times=100000;
		startTime=System.currentTimeMillis();
		addTestUsers(times);
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("MDB add "+times+" pieces of data needs "+totalTime+" ms");
		assertEquals(userDao.findAll().size(), times);
//		userDao.deleteAll();
	}
	@Test
	public void findbyIdPerformance(){
		long startTime,totalTime;
		int times=100000;
		int findNumber=5000;
//		addTestUsers(times);
		startTime=System.currentTimeMillis();
		List<User>resUsers=new ArrayList<User>();
		for (int i = 0; i < findNumber; i++) {
			resUsers.add(userDao.findById(i));
		}
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("MDB find by id "+findNumber+" pieces of data needs "+totalTime+" ms");
		assertEquals(resUsers.size(), findNumber);
//		userDao.deleteAll();
	}
	@Test
	public void findbyNamePerformance(){
		long startTime,totalTime;
		int times=100000;
		int findNumber=250;
//		addTestUsers(times);
		startTime=System.currentTimeMillis();
		List<User>resUsers=new ArrayList<User>();
		for (int i = 0; i < findNumber; i++) {
			resUsers.addAll(userDao.findByName(Integer.toString(i)));
		}
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("MDB find by name"+findNumber+" pieces of data needs "+totalTime+" ms");
		assertEquals(resUsers.size(), findNumber);
//		userDao.deleteAll();
	}
//	@Test
//	public void deletebyIdPerformance() {
//		int deleteItems=3000;
//		int times=100000;
//		long startTime,totalTime;
////		addTestUsers(times);
//		startTime=System.currentTimeMillis();
//		for (int i = 0; i < deleteItems; i++) {
//			userDao.deleteById(i);
//		}
//		totalTime=System.currentTimeMillis()-startTime;
//		System.out.println("MDB delete by id"+deleteItems+" pieces of data needs "+totalTime+" ms");
//		assertEquals(userDao.findAll().size(), times-deleteItems);
//		userDao.deleteAll();
//	}
}
