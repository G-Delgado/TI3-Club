package model;

import java.util.ArrayList;

public class Team {
	
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
	
	public Team (String teamName, MainCoach mainCoach) {
		maxPlayers = 0;
		maxAssistants = 0;
		this.teamName = teamName;
		players = new ArrayList<Player>(); // Me tengo que asegurar que no sobrepase el limite
		technicalAssistants = new ArrayList<Assistant>(); // Me tengo que asegurar que no sobrepase el limite
		this.mainCoach = mainCoach;
	}
}