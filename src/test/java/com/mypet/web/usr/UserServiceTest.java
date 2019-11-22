package com.mypet.web.usr;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mypet.web.cfg.ServletConfig;

import jdk.nashorn.internal.ir.annotations.Ignore;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServletConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class UserServiceTest {
	@Autowired UserService userService;
	@Ignore
	public void testTest() {
		
	}
	@Test
	public void testselectAll() {
		assertThat(userService.selectAll(), is(equalTo("5")));
	}
	@Test
	public void testselectUname() {
		assertThat(userService.selectUname(), is(equalTo("11")));
	}

}
