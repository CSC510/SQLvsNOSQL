package com.webapp.dao.impl.mdb;

import static org.junit.Assert.assertEquals;

import java.util.*;
import java.io.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.UserDao;
import com.webapp.daoimpl.mdb.HouseMDBImpl;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.House;
import com.webapp.model.User;

import java.util.List;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.*;







import static org.junit.Assert.assertEquals;

import java.util.ArrayList;



import org.slf4j.LoggerFactory;

import com.webapp.common.util.SpringContextHolder;



public class UserMDBImplMultiThreadTest extends SpringTransactionContextTest{
	
	public static final int NUM_THREADS = 8;

	@Test
	public void multi(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int sum =1000;
		int perThread = sum/NUM_THREADS;
		for(int i=0; i< NUM_THREADS; i++){
			
			threads.add(new Thread(new SimpleTest(perThread)));
			System.gc();
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
		for(int i=0; i< scale; i++){
			User u = new User();
			u.setName("test"+i);
			userDao.save(u);
		}
		
		
		long endTime = System.currentTimeMillis();
		logger.info("insert "+ scale+ " takes "+ (endTime-startTime) + "ms");
		System.gc();
		
	}
	
}
