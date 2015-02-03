package com.palindrome.ws.response;

import java.util.ArrayList;

import com.palindrome.core.domain.Player;

/**
 * 
 * @author manpreet
 * Response Object
 */

public class PalindromeResponse {

	private String name;
	private double score;
	private String text;
	private ArrayList<Player> players;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setHallOfFameResult(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Player> getHallOfFameResult() {
		return players;
	}

}
