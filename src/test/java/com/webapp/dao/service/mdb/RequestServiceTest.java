package com.webapp.dao.service.mdb;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.service.RequestService;
@Component
public class RequestServiceTest extends SpringTransactionContextTest {
	
	@Resource
	private RequestService requestService;
	
	
}
