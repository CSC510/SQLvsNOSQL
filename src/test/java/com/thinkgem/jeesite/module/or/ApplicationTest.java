package com.thinkgem.jeesite.module.or;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.thinkgem.jeesite.common.test.SpringTransactionalContextTests;
import com.thinkgem.jeesite.modules.oa.dao.LeaveDao;
import com.thinkgem.jeesite.modules.oa.entity.Leave;
import com.thinkgem.jeesite.modules.or.dao.ApplicationMdbDao;
import com.thinkgem.jeesite.modules.or.dao.ApplicationSQLDao;
import com.thinkgem.jeesite.modules.or.entity.Application;
import com.thinkgem.jeesite.modules.or.entity.House;
import com.thinkgem.jeesite.modules.or.service.ApplicationService;
import com.thinkgem.jeesite.modules.or.service.HouseService;

public class ApplicationTest extends SpringTransactionalContextTests {
	

	
	@Autowired
	private ApplicationMdbDao applicationMdbDao;
	@Autowired
	private ApplicationSQLDao applicationSQLDao;
	@Autowired
	private LeaveDao leaveDao;
	@Autowired
	private HouseService houseService;
	@Test
	public void newApplication(){
		House house = new House();
		houseService.save(house);
		house.setAddress("KingsCourt");
		houseService.save(house);
		
	}

}
