package com.webapp.dao.impl.mdb;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.UserMDBImpl;
import com.webapp.model.User;

public class UserMDBImplTest extends SpringTransactionContextTest {
	
	@Resource(name = "userMDBImpl")
	private UserMDBImpl userDao;
	
	@Test
	public void findAllUser(){
		List<User> result =userDao.findAll();
		System.out.println(result.size());
	}
}
