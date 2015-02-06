package com.webapp.dao.impl.mdb;



import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;

public class UserMDBImplTest extends SpringTransactionContextTest {
	
	@Resource(name = "userMDBImpl")
	private UserMDBImpl userDao;
	
	@Test
	public void findAllUser(){
		List<User> result =userDao.findAll();
		//assertThat(result.size(),60);
	}
	
	@Test
	@Rollback(true)
	public void findByString(){
		User u = new User("jiang", 12);
		User u1 = new User("jiang", 13);
		userDao.save(u);
		userDao.save(u1);
		List<User> result = userDao.findAll("{ studentId : {$in :[12, 13]}}");
		assertEquals( result.size(),2);
	}
	
	@Test
	
	public void delete(){
		User user = new User("jiang", 213);
		userDao.save(user);
		User u = userDao.findById(user.getId());
		userDao.delete(u);
		assertEquals(userDao.findOne("{name: 'jiang', studentId : 213 }"), null);
	}
	
	@Test
	@Rollback
	public void deleteById(){
		User user = new User("jiang", 23);
		userDao.save(user);
		userDao.deleteById(user.getId());
		assertEquals(userDao.findOne("{name: 'jiang', studentId : 23 }"), null);

	}
	
	
}
