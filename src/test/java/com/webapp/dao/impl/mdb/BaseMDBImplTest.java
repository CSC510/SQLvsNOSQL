package com.webapp.dao.impl.mdb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.BaseMDBImpl;
import com.webapp.model.User;
@ContextConfiguration(locations="/META-INF/mongo-config.xml")
public class BaseMDBImplTest extends SpringTransactionContextTest{
	
	@Resource(name = "baseMDBImpl")
    private BaseMDBImpl<User> mongoDao;
	
	/**
	 *  Initialization of Spring Context , Get Bean from ApplicationContext 
	 *
	@BeforeClass
	public static void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/mongo-config.xml");
		mongoDao = (BaseMDBImpl<User>) ctx.getBean("baseMDBImpl");
	}
	*/
	
	@Test
	@Rollback(true)
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
	
	
	@Test(expected=NullPointerException.class)
	@Rollback(true)
	public void findbyId(){		
		int id=123;
		User u=mongoDao.findbyId(id);
		System.out.println(u.getName());
	}
//	
}
