package com.webapp.dao.impl.sql;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.common.util.SpringContextHolder;
import com.webapp.daoimpl.sql.UserSQLImpl;
import com.webapp.model.User;



public class UserSQLImplMultiThreadTest extends SpringTransactionContextTest{
	
	public static final int NUM_THREADS = 1;

	@Test
	public void multi(){
		ArrayList<Thread> threads = Lists.newArrayList();
		int sum =1000000;
		int perThread = sum/NUM_THREADS;
		for(int i=0; i< NUM_THREADS; i++){
			
			threads.add(new Thread(new SimpleTest(perThread)));
		}
		
		for(Thread td : threads){
			td.start();
		}
		
		while(sum>0){
			;
		}
	}
}

@Transactional
 class SimpleTest implements Runnable{

	private org.slf4j.Logger logger = LoggerFactory.getLogger(SimpleTest.class);
	private UserSQLImpl userDao = SpringContextHolder.getBean(UserSQLImpl.class);
	
	private List<User> users;
	private int scale;
	
	public SimpleTest(List<User> users){
		this.users = users;
		
	}
	
	public SimpleTest(int scale){
		this.scale = scale;
	}
	
	@Transactional
	public void saveUser(){
		long startTime = System.currentTimeMillis();
		for(int i=0; i< scale; i++){
			User u = new User();
			u.setName("test"+i);
			userDao.save(u);
			if(i%10000==0){
				System.gc();
				userDao.flush();
			}
		}
		
		long endTime = System.currentTimeMillis();
		logger.info("insert "+ scale+ " takes "+ (endTime-startTime) + "ms");
	}
	
	@Override
	public void run() {
		saveUser();
		
	}
	
}

