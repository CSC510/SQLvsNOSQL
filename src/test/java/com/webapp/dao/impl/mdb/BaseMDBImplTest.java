package com.webapp.dao.impl.mdb;

import javax.annotation.Resource;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.mdb.BaseMDBImpl;
import com.webapp.model.User;

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

	//findOne test! Wrong!
	@Test(expected=InvalidDataAccessApiUsageException.class)
	@Rollback(true)
	public void findById(){		
		int id=123;
		User u=mongoDao.findById(id);
		System.out.println(u.getName());
	}
	
	
}
