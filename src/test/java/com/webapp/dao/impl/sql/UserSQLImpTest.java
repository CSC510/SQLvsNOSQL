package com.webapp.dao.impl.sql;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.sql.UserSQLImpl;
import com.webapp.model.User;

public class UserSQLImpTest extends SpringTransactionContextTest {
	
	private static Logger logger = LoggerFactory.getLogger(UserSQLImpTest.class);
	
	@Resource(name = "userSQLImpl")
	private UserSQLImpl userDao;

	
	@Test
	public void saveAndDelete(){
		User u = new User();
		u.setName("test");
		userDao.save(u);
		long saveStart = System.currentTimeMillis();	
		userDao.flush();
		long saveEnd = System.currentTimeMillis();
		
		userDao.delete(u);
		long deleteStart = System.currentTimeMillis();
		userDao.flush();
		long deleteEnd = System.currentTimeMillis();
		logger.info("insert "+ 1 +" record takes "+ (saveEnd - saveStart)+"ms");
		logger.info("delete "+ 1 +" record takes "+ (deleteEnd - deleteStart) +"ms");
		
	}
}
