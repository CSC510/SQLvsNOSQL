package com.webapp.dao.impl.sql;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.UserDao;
import com.webapp.daoimpl.sql.UserSQLImpl;
import com.webapp.model.User;

public class UserSQLImpTest extends SpringTransactionContextTest {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(UserSQLImpTest.class);
	
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
	
	@Test
	public void findByName(){
		User u = new User();
		u.setName("test");
		userDao.save(u);
		commit();
		List<User> users = userDao.findByName("test");
		for(User user : users){
			System.out.println("u id:"+user.getId());
		}
	}


}
