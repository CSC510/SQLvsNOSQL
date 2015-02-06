package com.webapp.dao.impl.mdb;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.Rollback;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;

public class UserMDBImplTest extends SpringTransactionContextTest {
	
	@Resource(name = "userMDBImpl")
	private UserMDBImpl userDao;

	//Add User Test
	@Test
	@Rollback(true)
	public void save(){	
		User u = new User("jesse",123);
		userDao.save(u);
	}
	//add User List Test
	@Test
	@Rollback(true)
	public void saveList(){		
		List<User> userList=new ArrayList();
		User a = new User("a",1);
		User b = new User("b",2);
		User c = new User("c",2);
		userList.add(a);
		userList.add(b);
		userList.add(c);
		userDao.save(userList);
	}
	//findOne test!
	@Test
	@Rollback(true)
	public void findById(){		
		int id=123;
		User u=userDao.findById(id);
//		System.out.println(u.getName());
	}
	
	//FindAll test!
	@Test
	@Rollback(true)
	public void findAll(){		
		List<User> userList=userDao.findAll();
	}
	//	delete test! 
	@Test
	@Rollback
	public void deleteUser(){
		int id=123;
		userDao.deleteById(id);
	}
	//find by name test!
	@Test
	@Rollback
	public void findByName() {
		String string="a";
		List<User> users=userDao.findByName(string);
	}
	
	
}
