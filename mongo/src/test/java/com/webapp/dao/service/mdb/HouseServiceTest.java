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
		House house = new House("University Oaks",01,"apartment");
		this.houseService.addHouse(house);
		List<House> houses1 = houseService.findHouseByName("University Oaks");
		assertEquals(houses1.size(), 1);
		
		List<House> houses2 = houseService.findHousesByType("apartment");
		assertEquals(houses1.size(), 1);
		houseService.deleteHouseByName("University Oaks");
		
	}
}