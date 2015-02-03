package com.palindrome;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class PalindromeControllerTest extends PalindromeProjectApplicationTests {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).alwaysExpect(MockMvcResultMatchers.status().isOk()).build();
	}

	@Test
	public void playForPalindrome() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/palindrome/play?name=Manpreet&text=Madam, I'm Adam")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		System.out.println("Result for test playForPalindrome ==> " + result.getResponse().getContentAsString());
	}

	@Test
	public void playForNotPalindrome() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/palindrome/play?name=Manpreet&text=Able was I")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		System.out.println("Result for test playForNotPalindrome ==> " + result.getResponse().getContentAsString());
	}

	@Test
	public void playForHallOfFame() throws Exception {
		this.mockMvc.perform(get("/palindrome/play?name=Manpreet&text=Able was I")).andExpect(MockMvcResultMatchers.status().isOk());
		Thread.sleep(1000);
		this.mockMvc.perform(get("/palindrome/play?name=ManpreetSingh&text=Poor Dan is in a droop")).andExpect(MockMvcResultMatchers.status().isOk());
		Thread.sleep(1000);
		this.mockMvc.perform(get("/palindrome/play?name=Mandy&text=Do geese see God?")).andExpect(MockMvcResultMatchers.status().isOk());
		Thread.sleep(1000);
		this.mockMvc.perform(get("/palindrome/play?name=ManpreetSingh&text=Hello Just testing")).andExpect(MockMvcResultMatchers.status().isOk());
		Thread.sleep(1000);
		this.mockMvc.perform(get("/palindrome/play?name=Mandy&text=Madam, I'm Adam")).andExpect(MockMvcResultMatchers.status().isOk());
		Thread.sleep(10000);
		MvcResult result = this.mockMvc.perform(get("/palindrome/play?name=Manpreet&text=Poor Dan is in a droop")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		System.out.println("Result for test playForHallOfFame ==> " + result.getResponse().getContentAsString());
	}

	@Test
	public void testPalindromeService() throws Exception {
		org.junit.Assert.assertTrue(this.palindromeService.checkPalindrome("Madam, I'm Adam"));
		org.junit.Assert.assertTrue(this.palindromeService.checkPalindrome("Poor Dan is in a droop"));
		org.junit.Assert.assertTrue(this.palindromeService.checkPalindrome("Do geese see God?"));
		org.junit.Assert.assertFalse(this.palindromeService.checkPalindrome("Just ?Testing."));
		org.junit.Assert.assertFalse(this.palindromeService.checkPalindrome("Manpreet, trying best!"));
	}

}
