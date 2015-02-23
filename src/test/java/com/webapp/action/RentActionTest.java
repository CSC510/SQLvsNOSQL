package com.webapp.action;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.action.RentAction;
import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.House;
import com.webapp.model.User;

public class RentActionTest extends SpringTransactionContextTest{
	@Resource
	private RentAction rentAction;
	@Resource
	private UserAction userAction;
	@Resource
	private HouseAction houseAction;
	
	@Test
	public void rentActionTest(){
		User user = new User("maxlpy",100);
		userAction.addUser(user);
		House house = new House("WolfRidge", 200, "hall");
		houseAction.addHouse(house);
		
		List<House> rentHouse = houseAction.findHouseByName("WolfRidge"); 
		assertEquals(rentHouse.get(0).getHouseId(), 200);
		rentAction.setHouseType(rentHouse.get(0).getType());
		
		User rentUser = userAction.findByStudentId(100);
		assertEquals(rentUser.getStudentId(), 100);
		
		rentAction.setStudentId(rentUser.getStudentId());
		rentAction.setUserName(rentUser.getName());
		System.out.println(rentAction.execute());
		
		userAction.deleteByStudentId(100);
		houseAction.deleteHouseByName("WolfRidge");
	}
}
