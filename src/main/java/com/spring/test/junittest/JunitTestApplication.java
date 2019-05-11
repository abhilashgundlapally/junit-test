package com.spring.test.junittest;

import com.spring.test.junittest.config.JUnitTestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({ JUnitTestConfiguration.class })
public class JunitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitTestApplication.class, args);
	}

}
