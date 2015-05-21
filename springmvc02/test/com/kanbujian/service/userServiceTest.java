package com.kanbujian.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kanbujian.model.user;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class userServiceTest {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void setUp() throws Exception {
	   ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	   
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		userService us=(userService)ctx.getBean("userService");
		user u=new user("kanbujian","4321","3434@qq.com");
		us.add(u);
		
	}

}
