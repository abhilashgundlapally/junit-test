package com.spring.test.junittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JunitTestApplication.class)
@ActiveProfiles("test")
public class JunitTestApplicationTests {

	@Test
	public void contextLoads() {
	}

}
