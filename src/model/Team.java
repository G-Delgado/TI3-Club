package model;

import java.util.ArrayList;

public class Team {
	
	// Relations
	/*
	VARIABLES EXTRA, VOY A AGREGAR UNA PARA LOS PLAYERS Y OTRA PARA LOS ASISTENTES. DE ESTA FORMA
	CUANDO SUPEREN SUS LIMITES, ENVIO UN MENSAJE DE QUE NO ES POSIBLE. LUEGO, HAGO VALIDACIONES
	*/
	private int maxPlayers;
	private int maxAssistants;
	/*
	-------------------------------------------------------------------------------
	*/
	private String teamName;
	private ArrayList<Player> players; // Tiene hasta 25
	private ArrayList<Assistant> technicalAssistants; // Tiene hasta 3
	private MainCoach mainCoach;
	
	// Debo poder ser capaz de eliminar o agregar cualquiera de los empleados que tenemos aqui
	
	// Constructor
	
	public Team (String teamName) {
		maxPlayers = 0;
		maxAssistants = 0;
		this.teamName = teamName;
		players = new ArrayList<Player>(); // Me tengo que asegurar que no sobrepase el limite
		technicalAssistants = new ArrayList<Assistant>(); // Me tengo que asegurar que no sobrepase el limite
		this.mainCoach = null;
	}
	
	// Getters and Setters
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public MainCoach getMainCoach() {
		return mainCoach;
	}
	
	public ArrayList<Assistant> getTechnicalAssistants() {
		return technicalAssistants;
	}
	
	// Methods
	
	// toString methods
	
	public String toString() {
		String mainCoachString = mainCoach != null ? mainCoach.getName() + "\n" : "NULL" + "\n";
		String out = "-----------------------------------\n" +
		"Team name: " + teamName + "\n" +
		"Players: " + players.toString() + "\n" +
		"Main coach: " + mainCoachString +
		"Technical assistants: " + technicalAssistants.toString() + "\n";
		
		return out;
	}
}