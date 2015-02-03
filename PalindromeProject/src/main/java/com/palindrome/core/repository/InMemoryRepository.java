package com.palindrome.core.repository;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Repository;

import com.palindrome.core.domain.Player;

@Repository
public class InMemoryRepository implements GenericRepository {

	private ArrayList<Player> players = new ArrayList<Player>();

	@Override
	public Player findByName(String name) {
		for (Player player : players) {
			if (player.getName() != null && player.getName().equals(name)) {
				return player;
			}
		}
		return null;
	}

	@Override
	public void storePlayer(Player player) {
		players.add(player);
	}

	@Override
	public boolean isHallOfFame(Player player) {
		System.out.println("Player Size" + players.size());
		if (players.size() >= 3) {
			Collections.sort(players, new Player());
			//if (player.getScore() >= players.get(0).getScore()) {
				return true;
			//}
		}
		return false;
	}

	@Override
	public ArrayList<Player> getDataForHallOfFame() {
		Collections.sort(players, new Player());
		return players;
	}

}
