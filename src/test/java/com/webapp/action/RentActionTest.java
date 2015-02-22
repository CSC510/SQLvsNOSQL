package com.webapp.action;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.House;
import com.webapp.model.User;

public class RentActionTest extends SpringTransactionContextTest{
	
	
	@Resource
	private RentAction rentAction;
	
	
	@Test
	public void test(){
		User user=new User("jesse",001);
		House house= new House("WolfRidge", 0221, "Apartment");
		rentAction.setHouseType(house.getType());
		rentAction.setStudentId(user.getStudentId());
		rentAction.setUserName(user.getName());
		rentAction.execute();
	}
}
