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
		teamA = null;
		teamB = null;
		// Aqui ocurren las relaciones cintosas //------
		officeSector = new Coach[6][6];
		payroll = new ArrayList<Employee>();
		dressingRoomA = new Player[7][6];
		dressingRoomB = new Player[7][7];
	}
	
	// Getters and Setters
	
	// Methods ---------------------------- // Y tambien otro metodo para buscar un empleado y devolver el indice
	public void fireEmployee(String id) { // Lo podemos cambiar haciendo un metodo para despedir tambien en los equipos
		boolean found = false;
		for (int i = 0; i < payroll.size() && !found; i++) {
			if (id.equals(payroll.get(i).getId())) {
				payroll.remove(i);
				found = true;
			}
		}
		found = false;
		if  (teamA != null || teamB != null) {
			if (id.contains("J")) {
			if (teamA != null) {
				for (int i = 0; i < teamA.getPlayers().size() && !found; i++) {
				ArrayList<Player> mockPlayers = teamA.getPlayers();
				if (id.equals(mockPlayers.get(i).getId())){
					mockPlayers.remove(i);
					found = true;
					}
				}
			}

			if (teamB != null) {
				for (int i = 0; i < teamB.getPlayers().size() && !found; i++) {
				ArrayList<Player> mockPlayers = teamB.getPlayers();
				if (id.equals(mockPlayers.get(i).getId())){
					mockPlayers.remove(i);
					found = true;
					}
				}
			}
		} else {
			if (teamA.getMainCoach() != null && id.equals(teamA.getMainCoach().getId())) {
				// DELETE THE MAIN COACH;
			} else if (teamB.getMainCoach() != null && id.equals(teamB.getMainCoach().getId())) {
				// DELETE THE MAIN COACH;
			} else {
				if (teamA != null) {
					for (int i = 0; i < teamA.getTechnicalAssistants().size() && !found; i++) {
						ArrayList<Assistant> mockCoachs = teamA.getTechnicalAssistants();
						if (mockCoachs.get(i) != null && id.equals(mockCoachs.get(i).getId())){
							mockCoachs.remove(i);
							found = true;
						}
					}
				}
				
				if (teamB != null) {
					for (int i = 0; i < teamB.getTechnicalAssistants().size() && !found; i++) {
						ArrayList<Assistant> mockCoachs = teamB.getTechnicalAssistants();
						if (mockCoachs.get(i) != null && id.equals(mockCoachs.get(i).getId())){
							mockCoachs.remove(i);
							found = true;
							}
						}
					}
				}
			}
		} else {
			System.out.println("Neither of the two teams have been created yet");
		}
	}
	
	public int searchUserByIndex(String id) {
		int index = 0;
		boolean found = false;
		for (int i = 0; i < payroll.size() && !found; i++) {
			if (id == payroll.get(i).getId()) {
				index = i;
				found = true;
			}
		}
		return index;
	}
	
	public void createTeam(char opt, String teamName) {
		switch (opt) {
			case 'A':
				teamA = new Team(teamName);
				break;
			case 'B':
				teamB = new Team(teamName);
				break;
		}
	}
	
	public void addEmpToTeam(String id, char team) { // Este metodo se esta volviendo muy tedioso jummm
		Player mockPlayer = null;
		MainCoach mockMc = null;
		Assistant mockAs = null;
		if (payroll.get(searchUserByIndex(id)) instanceof Player) {
			mockPlayer = (Player)payroll.get(searchUserByIndex(id)); 
		} else if (payroll.get(searchUserByIndex(id)) instanceof MainCoach) {
			mockMc = (MainCoach)payroll.get(searchUserByIndex(id));
		} else {
			mockAs = (Assistant)payroll.get(searchUserByIndex(id));
		}
		switch (team) {
			case 'A':
				if (mockPlayer != null) {
					teamA.addEmployee(mockPlayer);
				} else if (mockMc != null) {
					teamA.addEmployee(mockMc);
				} else {
					teamA.addEmployee(mockAs);
				}
				break;
			case 'B':
				if (mockPlayer != null) {
					teamB.addEmployee(mockPlayer);
				} else if (mockMc != null) {
					teamB.addEmployee(mockMc);
				} else {
					teamB.addEmployee(mockAs);
				}
				break;
		}
	}
	
	public void removeFromTeam(String id, char team) {
		switch (team) {
			case 'A':
				teamA.removeEmployee(id);
				break;
			case 'B':
				teamB.removeEmployee(id);
				break;
		}
	}
	
	public void addEmpToOffice(String id) { // Necesito validar que aun hayan espacios --------------------------
		Coach mockEmployee = (Coach)payroll.get(searchUserByIndex(id));
		boolean isNull = false;
		for (int i = 0; i < officeSector.length && !isNull; i = i + 2) {
			for (int j = 0; j < officeSector[0].length && !isNull; j = j + 2) {
				if (officeSector[i][j] == null) {
					officeSector[i][j] = mockEmployee;
					isNull = true;
				}
			}
		}
	}
	
	public String showInOffice() {
		String out = "";
		for (int i = 0; i < officeSector.length; i++) {
			for (int j = 0; j < officeSector[0].length; j++) {
				if (officeSector[i][j] != null) {
					out += officeSector[i][j].getName() + "\t";
				} else {
					out += "Null" + "\t";
				}
			}
			out += "\n";
		}
		
		return out;
	}
	
	// Overloaded methods 
	public void addEmployee(String name, String id, double salary, String state, int yearsOfExperience, int managerOfTeams, int wonChampionships) {
		MainCoach mcMock = new MainCoach(name, id, salary, state, yearsOfExperience, managerOfTeams, wonChampionships);
		payroll.add(mcMock);
		System.out.println(mcMock.toString());
	}
	
	public void addEmployee(String name, String id, double salary, String state, int yearsOfExperience, boolean wasPlayer, String expertise) {
		Assistant acMock = new Assistant(name, id, salary, state, yearsOfExperience, wasPlayer, expertise);
		payroll.add(acMock);
		System.out.println(acMock.toString());
	}
	
	public void addEmployee(String name, String id, double salary, String state, int shirtNumber, int numberOfGoals, double averageRating, String position) {
		Player plMock = new Player(name, id, salary, state, shirtNumber, numberOfGoals, averageRating, position);
		payroll.add(plMock);
		System.out.println(plMock.toString());
	}
	// ------------------
	
	// toString methods
	
	public String employeesToString() {
		String out = "\n---- Employees ----\n";
		for (int i = 0; i < payroll.size(); i++){
			out += payroll.get(i).toString()  + "\n";
		}
		return out;
	}
	
	
	public String teamsToString() { 
		String teamAString = teamA != null ? teamA.toString() + "\n": "";
		String teamBString = teamB != null ? teamB.toString()  + "\n": "";
		String out = "";
		out += teamAString;
		out += teamBString;
		if (out.equals("")) {
			out = "\nNeither of the two teams have been created\n";
		}
		return out;
	}
	
	// To String de prueba ////////////////////
	public String technichalToString() {
		String out = "";
		for (Employee as: payroll) {
			if (as instanceof Assistant) {
				out += as.toString() + "\n";
			}
		}
		return out;
	}
}