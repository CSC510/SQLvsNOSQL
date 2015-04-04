package com.webapp.dao.impl.sql;

import org.hibernate.SessionFactory;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.sql.UserSQLImpl;
import com.webapp.model.User;

import java.util.List;
import java.util.ArrayList;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.common.util.SpringContextHolder;



public class UserSQLImplMultiThreadTest extends SpringTransactionContextTest{
	
	public static final int NUM_THREADS = 1;

	@Test
	public void multi(){
		ArrayList<Thread> threads = Lists.newArrayList();
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

@Transactional
 class SimpleTest implements Runnable{

	private org.slf4j.Logger logger = LoggerFactory.getLogger(SimpleTest.class);
	private UserSQLImpl userDao = SpringContextHolder.getBean(UserSQLImpl.class);

	private SessionFactory sessionFactory = SpringContextHolder.getBean("sessionFactory");

	private List<User> users;
	private int scale;
	
	public SimpleTest(List<User> users){
		this.users = users;
		
	}
	
	public SimpleTest(int scale){
		this.scale = scale;
	}
	

	
	@Transactional
	public void run() {
			try {
				sessionFactory.openSession().getTransaction().begin();
				long startTime = System.currentTimeMillis();
				for(int i=0; i< scale; i++){
					User u = new User();
					u.setName("test"+i);
					userDao.save(u);
					if(i%10000==0){
						//userDao.flush();
					}
				}
				//userDao.getSession().getTransaction().commit();
				//userDao.getSession().getTransaction().rollback();
				long endTime = System.currentTimeMillis();
				logger.info("insert "+ scale+ " takes "+ (endTime-startTime) + "ms");
				
			} catch (Exception e){
				e.printStackTrace();
			}
			
		
		
	}
	
}

