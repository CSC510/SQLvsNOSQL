package com.webapp.dao.service.mdb;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.House;
import com.webapp.service.HouseService;

public class HouseServiceTest extends SpringTransactionContextTest {
	
	@Resource
	private HouseService houseService;
	
	@Test
	public void saveHouse(){
		House house = new House("Nelson Hall",01,"hall");
		this.houseService.addHouse(house);
		List<House> houses1 = houseService.findHouseByName("Nelson Hall");
		assertEquals(houses1.size(), 1);
		
		List<House> houses2 = houseService.findHousesByType("hall");
		assertEquals(houses1.size(), 1);
		houseService.deleteHouseByName("Nelson Hall");
		
	}
}