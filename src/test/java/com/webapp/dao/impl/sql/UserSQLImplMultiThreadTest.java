package com.webapp.dao.impl.sql;

import static org.junit.Assert.assertEquals;






import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.sql.UserSQLImpl;
import com.webapp.model.User;

import java.util.List;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;





import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.common.util.SpringContextHolder;



public class UserSQLImplMultiThreadTest extends SpringTransactionContextTest{
	
	public static final int NUM_THREADS = 8;

	@Test
	public void multi(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
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
	
	@Override
	public void run() {
		
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
	
}
