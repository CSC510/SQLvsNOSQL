package com.thinkgem.jeesite.module.or;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.test.SpringTransactionalContextTests;
import com.thinkgem.jeesite.modules.or.dao.HouseSQLDao;
import com.thinkgem.jeesite.modules.or.entity.House;

public class HouseSQLDaoTest extends SpringTransactionalContextTests{
	@Autowired
	private HouseSQLDao houseSQLDao;
	
	
	@Test
	@Transactional(readOnly=false)
	public void save(){
		int n = 100000;
		long start = System.currentTimeMillis();
		for(int i=0; i< n; i++){
			House house = new House();
			house.setAddress("No."+i+" Street");
			house.setName("No."+ i+ " House");
			houseSQLDao.save(house);
		}
		
		System.out.println("========MySQL Insert "+ n +" records ========");
		System.out.println("takes "+ (System.currentTimeMillis()-start)+" mseconds");
	}
}
