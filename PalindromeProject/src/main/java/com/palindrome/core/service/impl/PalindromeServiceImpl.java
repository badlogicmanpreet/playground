package com.palindrome.core.service.impl;

import org.springframework.stereotype.Service;

import com.palindrome.core.service.PalindromeService;

@Service
public class PalindromeServiceImpl implements PalindromeService {

	private int count;
	private char[] ch;

	public boolean checkPalindrome(String text) {
		String input = text.replaceAll("[\\s\\-_?,.!']", "");

		setCapacity(input.length());
		String reversedInput = reverseMe(input);

		if (reversedInput.equalsIgnoreCase(input)) {
			return true;
		} else {
			return false;
		}
	}

	private void setCapacity(int capacity) {
		ch = new char[capacity];
		count = capacity;
	}

	private String reverseMe(String text) {
		char[] textArray = text.toCharArray();
		int n = count - 1;
		for (int j = n; j >= 0; --j) {
			char temp = textArray[j];
			ch[n - j] = temp;
		}
		text = new String(ch);
		return text;
	}

}
