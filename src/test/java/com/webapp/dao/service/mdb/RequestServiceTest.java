package com.webapp.dao.service.mdb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.service.RequestService;
@Component
public class RequestServiceTest extends SpringTransactionContextTest {
	
	@Autowired
	private RequestService requestService;
	
	
}
