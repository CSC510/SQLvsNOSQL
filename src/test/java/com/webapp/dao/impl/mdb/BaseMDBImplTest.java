package com.webapp.dao.impl.mdb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.BaseMDBImpl;
import com.webapp.model.User;

public class BaseMDBImplTest extends SpringTransactionContextTest{
	
	@Resource(name = "baseMDBImpl")
        private BaseMDBImpl<User> mongoDao;
	
	@Test
	//@Rollback(true)
	public void save(){	
		User u = new User("jesse",123);
		mongoDao.save(u);
	}
	
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
		mongoDao.save(userList);
	}
}
