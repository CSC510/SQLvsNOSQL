package com.webapp.common.test;


import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class) 
@ActiveProfiles("test")
@ContextConfiguration(locations = {"/mongo-config.xml","/sql-config.xml"})
@Transactional
public class SpringTransactionContextTest  {
	@Autowired
	protected SessionFactory sessionFactory;
	
	public void commit(){
		sessionFactory.getCurrentSession().flush();
	}
	
}
