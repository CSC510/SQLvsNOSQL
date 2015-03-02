package com.thinkgem.jeesite.module.or;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.thinkgem.jeesite.common.test.SpringTransactionalContextTests;
import com.thinkgem.jeesite.modules.or.dao.HouseMdbDao;
import com.thinkgem.jeesite.modules.or.entity.House;

public class HouseMdbDaoTest extends SpringTransactionalContextTests {
	@Autowired
	private HouseMdbDao houseMdbDao;
	
	@Test
	public void save(){
		int n = 100000;
		
		long start = System.currentTimeMillis();
		for(int i=0; i<n; i++){
			House house = new House();
			house.setAddress("No."+i+" Street");
			house.setName("No."+ i+ " House");
			houseMdbDao.save(house);
		}
		
		System.out.println("========MongoDB Insert "+ n +" records ========");
		System.out.println("takes "+ (System.currentTimeMillis()-start)+" mseconds");
		
	}
}
