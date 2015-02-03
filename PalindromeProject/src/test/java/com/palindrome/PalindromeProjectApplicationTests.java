package com.palindrome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

import com.palindrome.core.service.PalindromeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PalindromeProjectApplication.class)
@WebAppConfiguration
public class PalindromeProjectApplicationTests {

	@Autowired
	protected WebApplicationContext wac;
	
	@Autowired
	protected PalindromeService palindromeService;

	@Test
	public void contextLoads() {
	}

}
