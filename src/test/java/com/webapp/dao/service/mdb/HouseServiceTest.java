package com.webapp.dao.service.mdb;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.House;
import com.webapp.service.HouseService;

public class HouseServiceTest extends SpringTransactionContextTest {
	
	private Logger logger = LoggerFactory.getLogger(HouseServiceTest.class);
	
	@Resource
	private HouseService houseService;
	
	@Test
	public void save(){
		House house = new House();
		house.setName("testHouse");
		house.setType("normal");
		this.houseService.save(house);
		commit();
		
		List<House> result = this.houseService.find(house);
		logger.info("result size "+ result.size());
		this.houseService.delete(house);
		commit();
	}
}