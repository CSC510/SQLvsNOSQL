package com.webapp.dao.impl.sql;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.Rollback;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.daoimpl.sql.BaseSQLImpl;
import com.webapp.model.User;

public class BaseSQLImplTest extends SpringTransactionContextTest{
	
	@Resource(name = "baseMDBImpl")
    private BaseSQLImpl<User> sqlDao;
	
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
		User u=sqlDao.findById(id);
		System.out.println(u.getName());
	}
	
	
}
