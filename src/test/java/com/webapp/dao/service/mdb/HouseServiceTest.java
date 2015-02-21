package com.webapp.dao.service.mdb;

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
	}
}