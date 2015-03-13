package com.webapp.dao.impl.mdb;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.HouseMDBImpl;
import com.webapp.model.House;

public class HouseMDBImplTest extends SpringTransactionContextTest{
	@Resource(name = "houseMDBImpl")
	private HouseMDBImpl houseDao;
	
//	@Test
	public void findAllHouse(){
		List<House> result =houseDao.findAll();
		//assertThat(result.size(),60);
	}
	
	@Test
	public void savehouse() {
		House h1 = new House();
		h1.setName("Hunt Hall");
		h1.setType("Apartment");
		houseDao.save(h1);
		House h3 = houseDao.findOne("{name: 'Hunt Hall', type: 'Apartment'}");
		assertEquals(h3.getType(), "Apartment");
		houseDao.deleteById(h1.getId());
	}
	
}
