package com.webapp.dao.service.mdb;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.action.RentAction;
import com.webapp.common.test.SpringTransactionContextTest;



public class RentTest extends SpringTransactionContextTest {
	
	@Autowired
	private RentAction rentAction;
	
	@Test
	public void test(){
	
//		rentAction.setHouseType(house.getType());
//		rentAction.setStudentId(user.getStudentId());
//		rentAction.setUserName(user.getName());
//		rentAction.execute();
	}
	
}
