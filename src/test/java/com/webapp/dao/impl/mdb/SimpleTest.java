package com.webapp.dao.impl.mdb;

import static org.junit.Assert.assertEquals;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;

public class SimpleTest extends SpringTransactionContextTest implements Runnable
{
	@Resource(name = "userMDBImpl")
	private UserMDBImpl userDao;
	static int count = 0;
	int start;
	int stop;
	
	public SimpleTest(int startValue, int stopValue)
	{
		start = startValue;
		stop = stopValue;
	}
	public static void count(){
		System.out.println(count++);
	}
	public void run()
	{
		for(int i = start; i < stop; i++)
		{
			System.out.println("flag1");
			count();
//			User user=userDao.findOne("{studentId : 23 }");
		
			
			System.out.println("flag2");
		}
	}

}
