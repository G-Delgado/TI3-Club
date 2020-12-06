package model;

import java.util.ArrayList;

public class Team {
	
	// --------------------- Atributes and relations --------------------- //
	
	public static final int MAX_PLAYERS = 25; // Constant, used to have a limit in the ArrayList of Players
	public static final int MAX_ASSISTANTS = 3; // Constant, used to have a limit in the ArrayList of Assistants
	
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
	* Team's constructor. <br>
	* pre: The teamName must be defined. <br>
	* pos: The values of the corresponding atributes are now the ones passed by the parameters. Also, the ArrayLists are initialized as well as some atributes.<br>
	* @param teamName. Represents the name of the team.
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
	
	public void setMainCoach(MainCoach mainCoach) {
		this.mainCoach = mainCoach;
	}
	
	public ArrayList<Assistant> getTechnicalAssistants() {
		return technicalAssistants;
	}
	
	// --------------------- Methods --------------------- //
	
	/**
	* Checks whether the player is in the team. <br>
	* pre: The id must be defined.<br>
	* pos: <br>
	* @param id. Represents the id of the player to find.
	* @return found. A boolean that represents whether the player was found in the team or not. <br>
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
	* Checks whether the coach is in the team. <br>
	* pre: The id must be defined.<br>
	* pos: <br>
	* @param id. Represents the id of the coach to find.
	* @return found. A boolean that represents whether the coach was found in the team or not. <br>
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
	* Adds an employee of instance player. <br>
	* pre: The player must be defined.<br>
	* pos: A new player is added to the ArrayList of players and the amountOfPlayers increases by 1.<br>
	* @param player. Represents the player to add.
	*/
	
	public void addEmployee(Player player) {
		if (spaceForPlayers()) {
			players.add(player);
			amountOfPlayers++;
		}
	}
	
	/**
	* Adds an employee of instance MainCoach. <br>
	* pre: The main coach must be defined. <br>
	* pos: The coach replaces the null value. <br>
	* @param mc. Represents the main coach to add.
	*/
	
	public void addEmployee(MainCoach mc) {
		if (mainCoach == null) {
			mainCoach = mc;
		}
	}
	
	/**
	* Adds an employee of instance Assistant. <br>
	* pre: The assistant must be defined.<br>
	* pos: A new assistant is added to the ArrayList of technicalAssistants and the amountOfAssistants increases by 1.<br>
	* @param as. Represents the assistant to add.
	*/
	
	public void addEmployee(Assistant as) {
		if (spaceForAssistants()) {
			technicalAssistants.add(as);
			amountOfAssistants++;
		}
	}
	
	/**
	* Removes an employee based on their id. <br>
	* pre: The id must be defined.<br>
	* pos: If found, the employee identified by that id is remove from the team.<br>
	* @param id. Represents the id of the employee to remove.
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
	* Checks whether there is space for more players and returns the result. <br>
	* pre: <br>
	* pos: <br>
	* @return thereIsSpace. Can be whether true or false. True if there is space and false if not. 
	*/
	
	public boolean spaceForPlayers() {
		boolean thereIsSpace = false;
		if (amountOfPlayers < MAX_PLAYERS) {
			thereIsSpace = true;
		}
		return thereIsSpace;
	}
	
	/**
	* Checks whether there is space for more assistants and returns the result. <br>
	* pre: <br>
	* pos: <br>
	* @return thereIsSpace. Can be whether true or false. True if there is space and false if not. 
	*/
	
	public boolean spaceForAssistants() {
		boolean thereIsSpace = false;
		if (amountOfAssistants < MAX_ASSISTANTS) {
			thereIsSpace = true;
		}
		return thereIsSpace;
	}
	
	/**
	* Adds a new alignment to the team. 
	* pre: All the parameters must be defined. <br>
	* pos: A new object of instance Alignment will be added in the ArrayList of alignment. <br>
	* @param date. Represents the date of the alignment to add. <br>
	* @param formation. Represents the binary matrix of the formation. <br>
	* @param tactic. Represents the tactic of the alignment. 
	*/
	
	public void addAlignment(String date, int[][] formation, String tactic) {
		alignments.add(new Alignment(date, formation, tactic));
	}
	
	// --------------------- toString methods ----------------- //
	
	/**
	* Returns a String with the information of the team. <br>
	* pre: <br>
	* pos: <br>
	* @return out. A string that contains all the information of the team.
	*/
	
	@Override
	public String toString() {
		String mainCoachString = mainCoach != null ? mainCoach.getName() + "\n" : "NULL" + "\n";
		String out = "-----------------------------------\n" +
		"Team name: " + teamName + "\n" +
		"Players: " + players.toString() + "\n" +
		"Main coach: " + mainCoachString +
		"Technical assistants: " + technicalAssistants.toString() + "\n" +
		"Alignments: " + alignments.toString() + "\n";
		
		return out;
	}
}