package com.webapp.action;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.model.User;

public class UserActionTest extends SpringTransactionContextTest {
	@Resource
	private UserAction userAction;
	
	@Test
	public void addUser() {
		User u = new User("fred", 88);
		userAction.addUser(u);
		assertEquals(userAction.findByStudentId(88).getStudentId(), 88);
		userAction.deleteByStudentName("fred");
	}
}
