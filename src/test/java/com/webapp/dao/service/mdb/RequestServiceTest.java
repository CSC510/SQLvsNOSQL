package com.webapp.dao.service.mdb;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Component;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.House;
import com.webapp.model.Request;
import com.webapp.model.User;
import com.webapp.service.RequestService;
@Component
public class RequestServiceTest extends SpringTransactionContextTest {
	
	@Resource
	private RequestService requestService;
	
	@Test
	public void saveRequest(){
		House house = new House("Nelson Hall",01,"hall");
		User user= new User("Jesse",3);
		
		Request request =new Request();
		request.setHouse(house);
		request.setUser(user);
		this.requestService.saveRequest(request);
	}
}
