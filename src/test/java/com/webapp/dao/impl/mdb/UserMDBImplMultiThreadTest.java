package com.webapp.dao.impl.mdb;




import org.junit.Test;

import com.google.common.collect.Lists;
import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.UserDao;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;

import java.util.List;

import org.slf4j.*;

import static org.junit.Assert.assertEquals;





import java.util.ArrayList;







import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.common.util.SpringContextHolder;



public class UserMDBImplMultiThreadTest extends SpringTransactionContextTest{
	
	public static final int NUM_THREADS = 1;
	private Logger logger = LoggerFactory.getLogger(UserMDBImplMultiThreadTest.class);
	@Resource(name = "userMDBImpl")
	private UserMDBImpl userDao;
	
	
	
	
	@Test
	public void multi(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int sum =10000;
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

	private static Logger logger = (Logger) LoggerFactory.getLogger(SimpleTest.class);
	private UserDao userDao = SpringContextHolder.getBean(UserMDBImpl.class);
	

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
		long totalTime = 0;
		startTime = System.currentTimeMillis();

		for(int i=0; i< scale; i++){
			User u = new User();
			u.setName("test"+i);
			userDao.save(u);
		}
		totalTime +=System.currentTimeMillis() - startTime; 

		
		logger.info("insert "+ scale+ " takes "+ (totalTime) + "ms");
		
	}
	
}
