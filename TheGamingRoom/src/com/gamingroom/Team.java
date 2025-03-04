package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{
	long id;
	String name;
	
	private static List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Player addPlayer(String name) {

		// a local Player instance
		Player player = null;

		// iterate over players to look for existing players with the same name and if found return the existing instance
		for (int i = 0; i < ((List<Player>) player).size() - 1; i++) {
			// looks through players list to see if name exists
			if (((List<Player>) player).get(i).getName() == name) {
				player = ((List<Player>) player).get(i);
			}
		}
		
		// if not found, make a new player instance and add to list of teams
		if (player == null) {
			// Get a reference to the GameService singleton instance
			GameService service = GameService.getInstance();
			
			//  Use the GameService Reference to call the getNextPlayerId() to get the Id to designate the player.
			player = new Player(service.getNextPlayerId(), name);
			((List<Player>) player).add(player);
		}

		// return the new/existing game instance to the caller
		return player;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
