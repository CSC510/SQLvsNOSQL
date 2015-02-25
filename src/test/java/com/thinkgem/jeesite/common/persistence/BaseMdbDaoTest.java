package com.thinkgem.jeesite.common.persistence;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.thinkgem.jeesite.common.test.SpringTransactionalContextTests;
import com.thinkgem.jeesite.modules.sys.entity.User;

public class BaseMdbDaoTest extends SpringTransactionalContextTests{

	@Autowired
	private BaseMdbDao<User> baseMdbDao;
	
	@Test
	public void save(){
		User u = new User();
        u.setName("gujaing");
        u.setEmail("jgu7@ncsu.edu");
        u.setNo("1234");
		baseMdbDao.save(u);
		User u2 = new User();
		u.setName("gujaing");
		u.setEmail("jgu7@ncsu.edu");
		u.setNo("1234");
		baseMdbDao.save(u2);
		
	}
}
