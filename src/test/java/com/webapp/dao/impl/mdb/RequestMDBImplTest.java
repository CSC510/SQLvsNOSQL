package com.webapp.dao.impl.mdb;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.common.persistence.Parameter;
import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.HouseMDBImpl;
import com.webapp.daoimpl.mdb.RequestMDBImpl;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.House;
import com.webapp.model.Request;
import com.webapp.model.User;

public class RequestMDBImplTest extends SpringTransactionContextTest {
	private Logger logger = LoggerFactory.getLogger(RequestMDBImplTest.class);
	@Autowired
	private UserMDBImpl userDao;
	@Autowired
	private HouseMDBImpl houseDao;
	@Autowired
	private RequestMDBImpl requestDao;
	
	private int count =10000;
	private int per =100;
	
	public void save(int count, int per){
		//int count =1000;
		for(int i=0;i<count ; i++){
		House house = new House();
		house.setName("testHouse"+i);
		house.setType("generic");
		houseDao.save(house);
		
		User user = new User();
		user.setName("test user"+i);
		userDao.save(user);
		for(int j =0; j<per; j++){
			Request req = new Request();
			req.setHouse(house);		    
		    req.setComment("test request"+(i*per+j));
		    user.getRequestList().add(req);
			
		}
		userDao.save(user);
		}
	}
	@Test
	public void findUserRequest(){
		long start, end;
		int n=0;
		save(count,per);
		Parameter parameter  = new Parameter();
		String userName = "test user"+ (int)(Math.random()*count);
		parameter.put("name", userName);
		start = System.currentTimeMillis();
		User u = userDao.findAll("{'name':'"+userName+"'}").get(0);
		List<Request> requests = u.getRequestList();
		for(Request re :requests){
			re.getHouse();
		}
		end = System.currentTimeMillis();
		n =  requests.size();
		logger.info("MDB find "+n+" records using embedded document takes "+(end- start)+"ms");
	
		
	}
	
	@Test
	public void nestedQuery(){
		long start, end;
		int n=0;
		
		start = System.currentTimeMillis();
		String comment = "test request"+ (int)(Math.random()*count*per);
		User u = userDao.findAll("{'requestList.comment':'"+comment+"'}").get(0);
		List<Request> requests = u.getRequestList();
		for(Request re :requests){
			re.getHouse();
		}
		end = System.currentTimeMillis();
		n =  requests.size();
		logger.info("MDB find "+n+" records using nested query takes "+(end- start)+"ms");
	
		
	}
	
	@Test
	public void findHouseRequest(){
		long start, end;
		int n=0;
		
		start = System.currentTimeMillis();
		String houseName = "testHouse"+ (int)(Math.random()*count);
		User u = userDao.findAll("{'requestList.house.name':'"+houseName+"'}").get(0);
		List<Request> requests = u.getRequestList();
		for(Request re :requests){
			re.getHouse();
		}
		end = System.currentTimeMillis();
		n =  requests.size();
		logger.info("MDB find "+n+" records using nested query takes "+(end- start)+"ms");
	
		
	}
}
