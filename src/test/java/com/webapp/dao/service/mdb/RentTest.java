package com.webapp.dao.service.mdb;


import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.action.RentAction;
import com.webapp.common.test.SpringTransactionContextTest;

public class RentTest extends SpringTransactionContextTest {
	
	@Resource
	private RentAction rentAction;
	@Test
	public void test(){
	
//		rentAction.setHouseType(house.getType());
//		rentAction.setStudentId(user.getStudentId());
//		rentAction.setUserName(user.getName());
//		rentAction.execute();
	}
	
}
