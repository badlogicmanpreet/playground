package com.palindrome.ws.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.palindrome.ws.request.PalindromeRequest;

@RestController("palindromeController")
public class PalindromeController {

	private static final Logger logger = Logger.getLogger(PalindromeController.class);

	@RequestMapping(value = "/play", method = RequestMethod.GET)
	public @ResponseBody String play(PalindromeRequest request, BindingResult result) {
		if (result.hasErrors()) {
			return "Bad Input";
		} else {

			return "You have hit play button";
		}
	}

}
