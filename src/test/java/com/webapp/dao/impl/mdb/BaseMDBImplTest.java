package com.webapp.dao.impl.mdb;

import javax.annotation.Resource;

import org.junit.Test;
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
	
	@Test
	@Repeat(4)
	@Rollback(true)
	public void save(){		
		User u = new User("jiang", 123);
		mongoDao.save(u);
	}	
	
}
