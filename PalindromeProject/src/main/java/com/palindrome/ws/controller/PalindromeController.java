package com.palindrome.ws.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palindrome.core.domain.Player;
import com.palindrome.core.repository.GenericRepository;
import com.palindrome.core.service.PalindromeService;
import com.palindrome.ws.response.PalindromeResponse;

@Controller
@RequestMapping("/palindrome")
public class PalindromeController {

	private static final Logger logger = Logger.getLogger(PalindromeController.class);

	private final GenericRepository repository;
	private final PalindromeService palindromeService;

	@Autowired
	public PalindromeController(GenericRepository repository, PalindromeService palindromeService) {
		this.repository = repository;
		this.palindromeService = palindromeService;
	}

	@RequestMapping(value = "/play", method = RequestMethod.GET)
	public @ResponseBody PalindromeResponse play(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "text", required = true) String text) {
		logger.info("play::params[name=" + name + ", text=" + text + "]");

		PalindromeResponse palindromeResponse = new PalindromeResponse();
		double score = 0.0;
		Player player;

		player = this.repository.findByName(name);
		if (player == null) {
			player = new Player();
			this.repository.storePlayer(player);
		}
		if (palindromeService.checkPalindrome(text)) {
			score = player.getScore() + text.length() / 2;
		} else {
			score = player.getScore();
		}
		player.setName(name);
		player.setScore(score);

		palindromeResponse.setName(name);
		palindromeResponse.setScore(score);
		palindromeResponse.setText(text);
        
		if(this.repository.isHallOfFame(player)) {
			palindromeResponse.setHallOfFameResult(this.repository.getDataForHallOfFame());
		}
		
		return palindromeResponse;
	}

}
