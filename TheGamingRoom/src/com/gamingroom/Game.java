package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	long id;
	String name;
	
	private static List<Team> teams = new ArrayList<Team>();
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Game() {
	}

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this();
		this.id = id;
		this.name = name;
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
	
	public Team addTeam(String name) {

		// a local Team instance
		Team team = null;

		// iterate over teams to look for existing team with the same name and if found return the existing instance
		for (int i = 0; i < ((List<Team>) team).size() - 1; i++) {
			// looks through teams list to see if name exists
			if (((List<Team>) team).get(i).getName() == name) {
				team = ((List<Team>) team).get(i);
			}
		}
		
		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			GameService service = GameService.getInstance();
			
			// Get a reference to the GameService instance and then call the getNextTeamId() to get the Id to designate the team.
			team = new Team(service.getNextPlayerId(), name);
			teams.add(team);
		}

		// return the new/existing game instance to the caller
		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}
	

}
