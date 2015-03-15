package com.webapp.dao.impl.mdb;

import static org.junit.Assert.assertEquals;

import java.util.*;
import java.io.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.HouseMDBImpl;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.House;
import com.webapp.model.User;

import java.util.List;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;


public class UserMDBImplMultiThreadTest extends SpringTransactionContextTest
{
	
	public static final int NUM_THREADS = 3;
	int TIMES = 4;
	
	@Resource(name = "userMDBImpl")
	private UserMDBImpl userDao;
	
	//@Test
	public void createList()
	{
		for(int i = 0; i < 100; i++)
		{
			User u = new User("hma", i);
			userDao.save(u);
		}
	}
	
	//@Test
	public void findByString()
	{
		for(int i = 0; i < TIMES; i++)
		{
			List<User> result = userDao.findAll("{ studentId : {$in :[12, 13]}}");
			assertEquals( result.size(),2 );
		}
	}
	
	int incrementAmount = TIMES / NUM_THREADS;
	
	@Test
	public void single()
	{
		findByString();
	}
	
	//Test
	public void multi()
	{
		ArrayList<Thread> threads = new ArrayList<Thread>();
	
		for(int i = 0; i < NUM_THREADS; i++)
		{
			threads.add(new Thread(new SimpleTest(i * 10, (i+1) * 1)));
		}
		for(int i = 0; i < threads.size(); i++)
		{
			threads.get(i).start();
			System.out.println(threads.size());
		}
		
	}
	

	
}
