package com.webapp.dao.impl.mdb;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
	@Repeat(4)
	@Rollback(true)
	public void save(){		
		User u = new User("jiang", 123);
		mongoDao.save(u);
	}
	
	
	
}
