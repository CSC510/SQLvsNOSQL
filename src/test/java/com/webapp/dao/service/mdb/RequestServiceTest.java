package com.webapp.dao.service.mdb;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Component;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.House;
import com.webapp.model.Request;
import com.webapp.model.User;
import com.webapp.service.HouseService;
import com.webapp.service.RequestService;
import com.webapp.service.UserService;
@Component
public class RequestServiceTest extends SpringTransactionContextTest {
	
	@Resource
	private RequestService requestService;
	
	
}
