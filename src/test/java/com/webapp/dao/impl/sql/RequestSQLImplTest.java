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
	
	private int count = 100;
	private int per =100;
	
	@Before
	public void save(){		
		for(int j=0 ; j<count ; j++){
		House house = new House();
		house.setName("testHouse"+j);
		house.setType("generic"+j);
		houseDao.save(house);
		
		User user = new User();
		user.setName("testUser"+j);
		userDao.save(user);
		//commit();
          
		for(int i=0; i< per; i++){
			Request req = new Request();
			//Pick a random house
			req.setHouse(house);
			req.setUser(user);
			req.setComment("test request"+(j*per+i));
			//user.getRequestList().add(req);
			//house.getRequestList().add(req);
			requestDao.save(req);
			
		}
		commit();
		}
		
	}
	
	@Test
	//@Rollback(false)
	public void findUserRequest(){		
		long start, end;
		int n=0;		
		start = System.currentTimeMillis();
		User user  = (User)userDao.findByName("testUser"+(int)(Math.random()*count)).get(0);
		/*Using hibernate relational mapping*/
		//List<Request> requests = user.getRequestList();
		/*Using sql query*/
		List<Request> requests = requestDao.findBySql("select * from request where user_id='"+user.getId()+"'");
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
		
		House house = (House)houseDao.findByType("generic"+(int)(Math.random()*count)).get(0);
		//List<Request> requests = house.getRequestList();
		start = System.currentTimeMillis();
		List<Request> requests = requestDao.findBySql("select * from request "
				                                     + "inner join house_request "
				                                     + "on request.id=house_request.request_id " 
				                                     + "inner join house "
				                                     + "on house.id=house_request.house_id "
				                                     + "where house.id='"+house.getId()+"'");
				                                     
		for(Request r : requests){
			r.getId();
			r.getUser();
		}
		end = System.currentTimeMillis();

		logger.info("SQL find "+requests.size()+" records by join table "+(end - start)+"ms");
		
	}
}
