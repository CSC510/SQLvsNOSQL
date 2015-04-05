package com.webapp.dao.impl.mdb;




import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.UserDao;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

import com.webapp.common.util.SpringContextHolder;
import com.webapp.daoimpl.mdb.BaseMDBImpl;



public class UserMDBImplMultiThreadTest extends SpringTransactionContextTest{
	
	public static final int NUM_THREADS = 1;
	private List<String> idsList=new ArrayList<String>();
	private int items=50;
	private int addItems=10000;
	@Before
	public void addTestUsers(){
		UserDao userDao = SpringContextHolder.getBean(UserMDBImpl.class);
		for (int i = 0; i < addItems; i++) {
			if (idsList.size()>items) {
				break;
			}
			User user=new User();
			user.setName(Integer.toString(i));
			userDao.save(user);
			int number=(int) (addItems*Math.random());
			if (number%((addItems/items)/3)==0) {
				idsList.add(user.getId());
			}
		}
	}

//	@Test
	public void multi(){
		UserDao userDao = SpringContextHolder.getBean(UserMDBImpl.class);
		userDao.deleteAll();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int sum =140000;
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
		int perThread = items/NUM_THREADS;
		if (idsList.size()<items) {
			System.out.println("missing items!!!!!");
		}
		for(int i=0; i< NUM_THREADS; i++){
			threads.add(new Thread(new FindTest(idsList.subList(i*perThread, (i+1)*perThread),perThread)));
			System.gc();
		}
		for(Thread td : threads){
			td.start();
		}
		while(items>0){
			;
		}
	}
	@Test
	public void multiDelete(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int perThread = items/NUM_THREADS;
		if (idsList.size()<items) {
			System.out.println("missing items!!!!!");
		}
		for(int i=0; i< NUM_THREADS; i++){
			threads.add(new Thread(new DeleteTest(idsList.subList(i*perThread, (i+1)*perThread),perThread)));
			System.gc();
		}
		for(Thread td : threads){
			td.start();
		}
		while(items>0){
			;
		}
	}
}

class FindTest implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(FindTest.class);
	private UserDao userDao = SpringContextHolder.getBean(UserMDBImpl.class);
	private List<String> usersId;
	private int scale;
	
	public FindTest(List<String> idsList,int scale){
		this.usersId = idsList;
		this.scale=scale;
	}
	public FindTest(int scale){
		this.scale = scale;
	}
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		for(int i=0; i< scale; i++){
			User user = ((BaseMDBImpl<User>) userDao).findById(usersId.get(i));
//			assertEquals(((BaseMDBImpl<User>) userDao).findOne(str).getName(), str1);	
		}
		long endTime = System.currentTimeMillis();
		logger.info("find "+ scale+ " takes "+ (endTime-startTime) + "ms");
		System.gc();
	}
}

class DeleteTest implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(DeleteTest.class);
	private UserDao userDao = SpringContextHolder.getBean(UserMDBImpl.class);
	private List<String> userIds;
	private int scale;
	
	public DeleteTest(List<String> users,int scale){
		this.userIds = users;
		this.scale=scale;
	}
	public DeleteTest(int scale){
		this.scale = scale;
	}
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		for(int i=0; i< scale; i++){
			((BaseMDBImpl<User>) userDao).deleteById(userIds.get(i));
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
