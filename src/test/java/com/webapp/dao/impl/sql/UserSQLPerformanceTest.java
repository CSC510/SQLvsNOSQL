package com.webapp.dao.impl.sql;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.sql.UserSQLImpl;
import com.webapp.model.User;

public class UserSQLPerformanceTest extends SpringTransactionContextTest{
	
	@Resource(name = "userSQLImpl")
	private UserSQLImpl userDao;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addTestUsers(int times){
		for (int i = 0; i < times; i++) {
			User user = new User();
			user.setName(Integer.toString(i));
			userDao.save(user);
		}
		
	}
	@Test
	public void simple(){
		String string="";
		long startTime,totalTime;
		
		startTime=System.currentTimeMillis();
		for (int i = 0; i <10000; i++) {
			string="insert into user(name) values('abc');\n ";
			jdbcTemplate.update(string);
		}
		
		
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("hrer"+totalTime);
	}

	@Test
	public void addPerformaceTest(){
		userDao.deleteAll();
		int threadCount=5;
		long startTime,totalTime;
		int times=1000;
		startTime=System.currentTimeMillis();
		addTestUsers(times);
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("SQL add "+times+" pieces of data needs "+totalTime+" ms");
		assertEquals(userDao.findAll().size(), times);
		userDao.deleteAll();
	}
//	@Test
	public void findbyIdPerformance(){
		long startTime,totalTime;
		int times=10000;
		int findNumber=5000;
		addTestUsers(times);
		startTime=System.currentTimeMillis();
		List<User>resUsers=new ArrayList<User>();
		for (int i = 0; i < findNumber; i++) {
			resUsers.add(userDao.findById(i));
		}
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("SQL find by id "+findNumber+" pieces of data needs "+totalTime+" ms");
		assertEquals(resUsers.size(), findNumber);
		userDao.deleteAll();
	}
	@Test
	public void findbyNamePerformance(){
		long startTime,totalTime;
		int times=10000;
		int findNumber=250;
		addTestUsers(times);
		startTime=System.currentTimeMillis();
		List<User>resUsers=new ArrayList<User>();
		for (int i = 0; i < findNumber; i++) {
			resUsers.addAll(userDao.findByName(Integer.toString(i)));
		}
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("SQL find by name"+findNumber+" pieces of data needs "+totalTime+" ms");
		assertEquals(resUsers.size(), findNumber);
		userDao.deleteAll();
	}
	@Test
	public void deletebyIdPerformance() {
		int deleteItems=3000;
		int times=10000;
		long startTime,totalTime;
		addTestUsers(times);
		
		List<User> userList=userDao.findAll();
		startTime=System.currentTimeMillis();
		int count =0;
		for (User user : userList) {
			userDao.deleteById(user.getId());
			count++;
			if (count==deleteItems) {
				break;
			}
		}
		totalTime=System.currentTimeMillis()-startTime;
		System.out.println("SQL delete by id"+deleteItems+" pieces of data needs "+totalTime+" ms");
		assertEquals(userDao.findAll().size(), times-deleteItems);
		userDao.deleteAll();
	}
}
