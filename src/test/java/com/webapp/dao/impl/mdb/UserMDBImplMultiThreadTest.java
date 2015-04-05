package com.webapp.dao.impl.mdb;




import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.UserDao;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;

import java.util.List;

import org.slf4j.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.common.util.SpringContextHolder;
import com.webapp.dao.UserDao;
import com.webapp.daoimpl.mdb.BaseMDBImpl;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;



public class UserMDBImplMultiThreadTest extends SpringTransactionContextTest{
	
	public static final int NUM_THREADS = 1;
	
//	@Before
	public void addTestUsers(int times){
		UserDao userDao = SpringContextHolder.getBean(UserMDBImpl.class);
		for (int i = 0; i < times; i++) {
			User user=new User();
			user.setName(Integer.toString(i));
			userDao.save(user);
//			idsList.add(user.getId());
		}
	}

	@Test
	public void multi(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int sum =100;
		int perThread = sum/NUM_THREADS;
		for(int i=0; i< NUM_THREADS; i++){
			threads.add(new Thread(new AddTest(perThread)));
			System.gc();
		}
		for(Thread td : threads){
			td.start();
		}
		while(sum>0){
			;
		}
	}
//	@Test
	public void multiFind(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int sum =50000;
		int perThread = sum/NUM_THREADS;
		for(int i=0; i< NUM_THREADS; i++){
			threads.add(new Thread(new FindTest(perThread)));
			System.gc();
		}
		for(Thread td : threads){
			td.start();
		}
		while(sum>0){
			;
		}
	}
//	@Test
	public void multiDelete(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int sum =40;

		int perThread = sum/NUM_THREADS;
		for(int i=0; i< NUM_THREADS; i++){
			threads.add(new Thread(new DeleteTest(perThread)));
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

class FindTest implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(FindTest.class);
	private UserDao userDao = SpringContextHolder.getBean(UserMDBImpl.class);
	private List<User> users;
	private int scale;
	
	public FindTest(List<User> users){
		this.users = users;
	}
	public FindTest(int scale){
		this.scale = scale;
	}
	@Override
	public void run() {
		
		long startTime = System.currentTimeMillis();
		for(int i=0; i< scale; i++){
			String str = "{name:'"+"test"+i+"'}";
			String str1 = "test"+i;
			User user = ((BaseMDBImpl<User>) userDao).findOne(str);
			assertEquals(((BaseMDBImpl<User>) userDao).findOne(str).getName(), str1);	
		}
		long endTime = System.currentTimeMillis();
		logger.info("find "+ scale+ " takes "+ (endTime-startTime) + "ms");
		System.gc();
	}
}

class DeleteTest implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(DeleteTest.class);
	private UserDao userDao = SpringContextHolder.getBean(UserMDBImpl.class);
	private List<User> users;
	private int scale;
	
	public DeleteTest(List<User> users){
		this.users = users;
	}
	public DeleteTest(int scale){
		this.scale = scale;
	}
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		for(int i=0; i< scale; i++){
			String str = "{name:'"+"test"+i+"'}";
			String str1 = "test"+i;
			User user = ((BaseMDBImpl<User>) userDao).findOne(str);
			userDao.delete(user);
			assertEquals(((BaseMDBImpl<User>) userDao).findOne(str), null);	
		}
		long endTime = System.currentTimeMillis();
		logger.info("delete "+ scale+ " takes "+ (endTime-startTime) + "ms");
		System.gc();
	}
}

class AddTest implements Runnable{

	private static Logger logger = LoggerFactory.getLogger(AddTest.class);
	private UserDao userDao = SpringContextHolder.getBean(UserMDBImpl.class);
	private List<User> users;
	private int scale;
	public AddTest(List<User> users){
		this.users = users;
	}
	public AddTest(int scale){
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
