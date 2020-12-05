package model;

import java.util.ArrayList;

public class Team {
	
	// --------------------- Atributes and relations --------------------- //
	
	public static final int maxPlayers = 25; // Constant, used to have a limit in the ArrayList of Players
	public static final int maxAssistants = 3; // Constant, used to have a limit in the ArrayList of Assistants
	
	private int amountOfPlayers; // Counter, increases when a player is added and decreases when a player is removed
	private int amountOfAssistants; // Counter, increases when an assistant is added and decreases when an assistant is removed
	
	private String teamName; // Is the name of the team which is defined in the constructor
	private ArrayList<Player> players; // ArrayList of Players, to have the players in order.
	private ArrayList<Assistant> technicalAssistants; // ArrayList of Assistants, to have the assitants in order.
	private MainCoach mainCoach; // The main coach of the theam which is added after the creation of the team.
	private ArrayList<Alignment> alignments; // ArrayList of alignments as there can be more than one.
	
	// -----------------------------------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	public Team (String teamName) {
		amountOfPlayers = 0;
		amountOfAssistants = 0;
		this.teamName = teamName;
		players = new ArrayList<Player>(); // Me tengo que asegurar que no sobrepase el limite
		technicalAssistants = new ArrayList<Assistant>(); // Me tengo que asegurar que no sobrepase el limite
		alignments = new ArrayList<Alignment>();
		this.mainCoach = null;
	}
	
	// ----------------------------------------------------------
	
	// --------------------- Getters and Setters --------------------- //
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public MainCoach getMainCoach() {
		return mainCoach;
	}
	
	public ArrayList<Assistant> getTechnicalAssistants() {
		return technicalAssistants;
	}
	
	// --------------------- Methods --------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	public boolean playerIsEmployee(String id) {
		boolean found = false;
		for (int i = 0; i < players.size() && !found; i++) {
			if (id.equals(players.get(i).getId())) {
				found = true;
			}
		}
		
		return found;
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public boolean coachIsEmployee(String id) {
		boolean found = false;
		for (int i = 0; i < technicalAssistants.size() && !found; i++) {
			if (id.equals(technicalAssistants.get(i).getId())) {
				found = true;
			}
		}

		if (mainCoach.getId().equals(id)) {
			found = true;
		}
		
		return found;
		
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addEmployee(Player player) {
		if (spaceForPlayers()) {
			players.add(player);
			amountOfPlayers++;
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addEmployee(MainCoach mc) {
		if (mainCoach == null) {
			mainCoach = mc;
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addEmployee(Assistant as) {
		if (spaceForAssistants()) {
			technicalAssistants.add(as);
			amountOfAssistants++;
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void removeEmployee(String id) {
		boolean found = false;
		for (int i = 0; i < players.size() && !found; i++) {
			if (id.equals(players.get(i).getId())) {
				players.remove(i);
				found = true;
			}
		}
		
		for (int i = 0; i < technicalAssistants.size() && !found; i++) {
			if (id.equals(technicalAssistants.get(i).getId())) {
				technicalAssistants.remove(i);
				found = true;
			}
		}
		
		if (!found) {
			mainCoach = null;
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public boolean spaceForPlayers() {
		boolean thereIsSpace = false;
		if (amountOfPlayers < maxPlayers) {
			thereIsSpace = true;
		}
		return thereIsSpace;
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public boolean spaceForAssistants() {
		boolean thereIsSpace = false;
		if (amountOfAssistants < maxAssistants) {
			thereIsSpace = true;
		}
		return thereIsSpace;
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addAlignment(String date, int[][] formation, String tactic) {
		
	}
	
	// --------------------- toString methods ----------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	@Override
	public String toString() {
		String mainCoachString = mainCoach != null ? mainCoach.getName() + "\n" : "NULL" + "\n";
		String out = "-----------------------------------\n" +
		"Team name: " + teamName + "\n" +
		"Players: " + players.toString() + "\n" + // Talvez no deberia poner toString si no getName
		"Main coach: " + mainCoachString +
		"Technical assistants: " + technicalAssistants.toString() + "\n";
		
		return out;
	}
}