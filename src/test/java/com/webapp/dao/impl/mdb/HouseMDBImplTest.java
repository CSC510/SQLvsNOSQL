package com.webapp.dao.impl.mdb;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.HouseMDBImpl;
import com.webapp.model.House;
import com.webapp.model.User;

public class HouseMDBImplTest extends SpringTransactionContextTest{
	@Resource(name = "houseMDBImpl")
	private HouseMDBImpl houseDao;
	
//	@Test
	public void findAllHouse(){
		List<House> result =houseDao.findAll();
		//assertThat(result.size(),60);
	}
	
	@Test
	public void save() {
		House u1 = new House("Hunt Hall", "Apartment");
		User u2 = null;
		userDao.save(u1);
		u2 = userDao.findOne("{name: 'fred', studentId: 100}");
		assertEquals(u2.getStudentId(), 100);
		userDao.deleteById(u1.getId());
	}
	
}
