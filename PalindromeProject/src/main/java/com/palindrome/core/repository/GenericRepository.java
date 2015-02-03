package com.palindrome.core.repository;

import java.util.ArrayList;

import com.palindrome.core.domain.Player;

/**
 * 
 * @author manpreet
 *
 * Repository Interface
 */

public interface GenericRepository {

	Player findByName(String name);

	void storePlayer(Player player);

	boolean isHallOfFame(Player player);

	ArrayList<Player> getDataForHallOfFame();

}
