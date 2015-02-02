package com.palindrome.core.service.impl;

import org.springframework.stereotype.Service;

import com.palindrome.core.service.PalindromeService;

@Service
public class PalindromeServiceImpl implements PalindromeService {

	public boolean checkPalindrome(String text) {
		String input = text.replaceAll("\\s+", "");

		StringBuffer buffer = new StringBuffer(input);
		String reversedInput = buffer.reverse().toString();

		if (reversedInput.equalsIgnoreCase(input)) {
			return true;
		} else {
			return false;
		}
	}

}
