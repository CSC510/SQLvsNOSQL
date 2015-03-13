package com.webapp.dao.service.mdb;


import java.util.List;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.action.RentAction;
import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.House;
import com.webapp.model.User;
import com.webapp.service.UserService;

public class RentTest extends SpringTransactionContextTest {
	
	@Resource
	private RentAction rentAction;
	@Test
	public void test(){
		User user=new User("Hongyi",001);
		House house= new House("University Oaks", 0221, "hall");
//		rentAction.setHouseType(house.getType());
//		rentAction.setStudentId(user.getStudentId());
//		rentAction.setUserName(user.getName());
//		rentAction.execute();
	}
	
}
