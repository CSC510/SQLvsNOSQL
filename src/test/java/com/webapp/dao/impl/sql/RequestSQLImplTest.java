package com.webapp.dao.impl.sql;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.sql.HouseSQLImpl;
import com.webapp.daoimpl.sql.RequestSQLImpl;
import com.webapp.daoimpl.sql.UserSQLImpl;
import com.webapp.model.House;
import com.webapp.model.Request;
import com.webapp.model.User;

public class RequestSQLImplTest extends SpringTransactionContextTest{
	
	private Logger logger = LoggerFactory.getLogger(RequestSQLImplTest.class);
	@Autowired
	private UserSQLImpl userDao;
	@Autowired
	private HouseSQLImpl houseDao;
	@Autowired
	private RequestSQLImpl requestDao;
	
	@Before
	public void performance(){
		int count =1000;
		House house = new House();
		house.setName("testHouse");
		house.setType("generic");
		houseDao.save(house);
		commit();
		User user = new User();
		user.setName("testUser");
		userDao.save(user);
		commit();
		for(int i=0; i<count; i++){
			
			Request req = new Request();
			req.setHouse(house);
			req.setUser(user);
			user.getRequestList().add(req);
			requestDao.save(req);
			
		}
		commit();

	}
	
	@Test
	public void find(){
		
		long start, end;
		int n=0;
		
		start = System.currentTimeMillis();
		User user  = (User)userDao.findByName("testUser").get(0);
		List<Request> requests = user.getRequestList();
		for(Request r : requests){
			r.getId();
			r.getUser();
		}
		end = System.currentTimeMillis();
		logger.info("SQL find "+requests.size()+" records by join column "+(end - start)+"ms");
	}
	
	@Test
	public void findHouseRequest(){
		long start, end;
		int n=0;
		
		start = System.currentTimeMillis();
		House house = (House)houseDao.findByType("generic").get(0);
		List<Request> requests = house.getRequestList();
		for(Request r : requests){
			r.getId();
			r.getUser();
		}
		end = System.currentTimeMillis();
		logger.info("SQL find "+requests.size()+" records by join table "+(end - start)+"ms");
		
	}
}
