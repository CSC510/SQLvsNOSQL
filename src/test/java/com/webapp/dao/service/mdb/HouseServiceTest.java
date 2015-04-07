package com.webapp.dao.service.mdb;

import java.util.List;



import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.House;
import com.webapp.service.HouseService;

public class HouseServiceTest extends SpringTransactionContextTest {
	
	private Logger logger = LoggerFactory.getLogger(HouseServiceTest.class);
	
	@Autowired
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