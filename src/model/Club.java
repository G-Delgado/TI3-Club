package model;

import java.util.ArrayList;

public class Club {
	
	// Relations
	
	private String clubName;
	private int nit;
	private String foundationDate;
	// Teams -------
	private Team teamA;
	private Team teamB;
	// Sectors ----------
	private Coach[][] officeSector;
	private ArrayList<Employee> payroll;
	private Player[][] dressingRoomA;
	private Player[][] dressingRoomB;
	// ------------------
	
	// Constructor
	
	public Club(String clubName, int nit, String foundationDate) {
		this.clubName = clubName;
		this.nit = nit;
		this.foundationDate = foundationDate;
		// Aqui ocurren las relaciones cintosas ------
		officeSector = new Coach[6][6];
		payroll = new ArrayList<Employee>();
		dressingRoomA = new Player[7][6];
		dressingRoomB = new Player[7][7];
	}
	
	// Getters and Setters
	
	// Methods
	
	// toString method
}