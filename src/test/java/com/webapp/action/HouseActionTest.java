package com.webapp.action;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Controller;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.House;

@Controller
public class HouseActionTest extends SpringTransactionContextTest {
	@Resource
	private HouseAction houseAction;
	
	@Test
	public void addHouse() {
		House house = new House("Nelson Hall",12,"hall");
		houseAction.addHouse(house);
		List<House> houses1 = houseAction.findHouseByName("Nelson Hall");
		assertEquals(houses1.size(), 1);
		houseAction.deleteHouseByName("Nelson Hall");
	}
}

