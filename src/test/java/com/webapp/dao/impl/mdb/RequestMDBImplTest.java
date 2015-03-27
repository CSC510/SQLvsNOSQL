package com.webapp.dao.impl.mdb;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
	
	@Test
	public void save(){
		House house = new House();
		house.setName("test1");
		house.setType("generic");
		houseDao.save(house);
		
		User user = new User();
		user.setName("test user");
		userDao.save(user);
		for(int i =0; i<10000; i++){
			Request req = new Request();
			req.setHouse(house);
				
		    //user.getRequestList().add(req);
		    
		    req.setComment("test request");
		    user.getRequestList().add(req);
			
		}
		userDao.save(user);
		long start, end;
		int n=0;
		start = System.currentTimeMillis();
		List<Request> requests = userDao.findById(user.getId()).getRequestList();
		for(Request re :requests){
			System.out.println(re.getHouse());
		}
		end = System.currentTimeMillis();
		n =  requests.size();
		logger.info("MDB find "+n+" records using embedded document takes "+(end- start)+"ms");
	
		
	}
	
	//@Test
	public void performance(){
		int count =1000;
		User user = new User();
		user.setName("testUser");
		userDao.save(user);
		
		House house = new House();
		house.setName("testHouse");
		house.setType("generic");
		houseDao.save(house);
		for(int i=0; i<count; i++){		
			Request req = new Request();
			req.setHouse(house);
			req.setUser(user);
			requestDao.save(req);
		}
	}
}
