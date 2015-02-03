package com.palindrome.core.domain;

import java.util.Comparator;

/**
 * 
 * @author manpreet
 * 
 * Player
 */

public class Player implements Comparator<Player>, Comparable<Player> {

	private String name;
	private double score = 0.0;

	public Player() {

	}

	public Player(String name, double score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public double getScore() {
		return score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int compareTo(Player o) {
		return this.name.compareTo(o.name);
	}

	public int compare(Player o1, Player o2) {
		if (o1.score > o2.score)
			return -1;
		if (o1.score < o2.score)
			return 1;
		return 0;
	}

}
