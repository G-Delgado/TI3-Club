package model;

import java.util.ArrayList;

public class Team {
	
	// --------------------- Atributes and relations --------------------- //
	/*
	VARIABLES EXTRA, VOY A AGREGAR UNA PARA LOS PLAYERS Y OTRA PARA LOS ASISTENTES. DE ESTA FORMA
	CUANDO SUPEREN SUS LIMITES, ENVIO UN MENSAJE DE QUE NO ES POSIBLE. LUEGO, HAGO VALIDACIONES
	*/
	private int maxPlayers;
	private int maxAssistants;
	/*
	-------------------------------------------------------------------------------
	*/
	
	/*
	TAMBIÉN PUEDO HACER QUE JUGADORES Y ASSISTANTS SEA UN ARRAY Y NO UN ARRAYLIST, ASI ME AHORRO EL VALIDAR LOS ESPACIOS
	*/
	private String teamName;
	private ArrayList<Player> players; // Tiene hasta 25
	private ArrayList<Assistant> technicalAssistants; // Tiene hasta 3
	private MainCoach mainCoach;
	private ArrayList<Alignment> alignments;
	
	// -----------------------------------------------------------------------
	
	// Debo poder ser capaz de eliminar o agregar cualquiera de los empleados que tenemos aqui
	
	// --------------------- Constructor --------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	public Team (String teamName) {
		maxPlayers = 0;
		maxAssistants = 0;
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
		if (maxPlayers < 25) {
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
		if (maxAssistants < 3) {
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