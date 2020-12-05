package model;

import java.util.ArrayList;

public class Club {
	
	// Atributes and relations --------- //
	private String clubName; // The name of the club, applied in the constructor
	private int nit; // The NIT of the club, applied in the constructor
	private String foundationDate; // The foundation date of the club, applied in the constructor
	// Teams ------------//
	private Team teamA; // The Team A of the club
	private Team teamB; // The Team B of the club
	// Sectors ----------//
	private Coach[][] officeSector; // The office sector, in which we can put any class that inherits from Coach.
	private ArrayList<Employee> payroll; // The Payroll, which is an ArrayList of Employees.
	private Player[][] dressingRoomA; // The dressing room A, in which we can put any player that belongs to Team A
	private Player[][] dressingRoomB; // The dressing room B, in which we can put any player that belongs to Team B
	// ---------------------------------//
	
	// --------------------- Constructor --------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
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
	
	// ----------------------------------------------------------
	
	// --------------------- Getters and Setters --------------------- //
	
	/*
		THERE IS THIS FIRE EMPLOEE METHOD THAT I AM PROBABLY GOING TO CHANGE, I DONT LIKE HOW EXTENSE IT IS AND I HAVENT FIXED THE MAIN COACH PART, SO AHA.
	---------------------------------------------------------------------------------------------
	SO, WHEN I AM DONE REFACTORING IT, I WILL PUT THE JAVADOC IN IT
	*/
	
	// --------------------- Methods ---------------------------- // Y tambien otro metodo para buscar un empleado y devolver el indice
	public void fireEmployee(String id) { // Lo podemos cambiar haciendo un metodo para despedir tambien en los equipos // WE ARE NOT DELETING THE MAIN COACH YET
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
				// DELETE THE MAIN COACH;--------------------
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
	
	/**
	*
	*
	*
	*
	*/
	
	public int searchEmployeeById(String id) {
		int index = 0;
		boolean found = false;
		for (int i = 0; i < payroll.size() && !found; i++) {
			if (id.equals(payroll.get(i).getId())) {
				index = i;
				found = true;
			}
		}
		return index;
	}
	
	/**
	*
	*
	*
	*
	*/
	
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

	/**
	*
	*
	*
	*
	*/

	public String addAlignmentToTeam(char team, String date, String[] formation, String tactic) { // REMEMBER I AM WORKING ON THIS
		
		String result = "";
		
		// Convert the formation to a matrix
		int[][] formationMatrix = new int[10][7];
		
		for (int i = formationMatrix.length/formation.length; i < formationMatrix.length; i = formationMatrix.length / formation.length){
			
			for (int j = formationMatrix[0].length/formation.length; j < formationMatrix[0].length; j++) {
				formationMatrix[i][j] = 1;
			}
		}
		switch (team) {
			case 'A':
				if (teamA != null) {
					teamA.addAlignment(date, formationMatrix, tactic);
					result = "Alignment succesfully added";
				} else {
					result = "Team A has not been created";
				}
				break;
			case 'B':
				if (teamB != null) {
					teamB.addAlignment(date, formationMatrix, tactic);
					result = "Alignment succesfully added";
				} else {
					result = "Team B has not been created";
				}
				break;
		}
		
		return result;
	}

	/**
	*
	*
	*
	*
	*/

	public void addEmpToTeam(String id, char team) { // Este metodo se esta volviendo muy tedioso jummm
		Player mockPlayer = null;
		MainCoach mockMc = null;
		Assistant mockAs = null;
		if (payroll.get(searchEmployeeById(id)) instanceof Player) {
			mockPlayer = (Player)payroll.get(searchEmployeeById(id));
			System.out.println("Llegue aqui!!!: Jugador: \n" + mockPlayer.toString());
		} else if (payroll.get(searchEmployeeById(id)) instanceof MainCoach) {
			mockMc = (MainCoach)payroll.get(searchEmployeeById(id));
			System.out.println("Llegue aqui!!!: Main Coach: \n" + mockMc.toString());
		} else {
			mockAs = (Assistant)payroll.get(searchEmployeeById(id));
			System.out.println("Llegue aqui!!!: Assistant: \n" + mockAs.toString());
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
	
	/**
	*
	*
	*
	*
	*/
	
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
	
	/**
	*
	*
	*
	*
	*/
	
	public void addEmpToOffice(String id) { // Necesito validar que aun hayan espacios --------------------------
		Coach mockEmployee = (Coach)payroll.get(searchEmployeeById(id));
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
	
	/**
	*
	*
	*
	*
	*/
	
	public void removeCoachFromOffice(String id) {
		boolean found = false;
		for (int i = 0; i < officeSector.length && !found; i = i+2) {
			for (int j = 0; j < officeSector[0].length && !found; j = j+2) {
				if (officeSector[i][j] != null && officeSector[i][j].getId().equals(id)) {
					officeSector[i][j] = null;
					found = true;
				}
			}
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addPlayerToDr(String id) {
		Player mockPlayer = (Player)payroll.get(searchEmployeeById(id));
		boolean isNull = false;
		if (teamA.playerIsEmployee(id)) {
			for (int i = 0; i < dressingRoomA.length && !isNull; i = i+2) {
				for (int j = 0; j < dressingRoomA[0].length && !isNull; j = j + 2) {
					if (dressingRoomA[i][j] == null) {
						dressingRoomA[i][j] = mockPlayer;
						isNull = true;
					}
				}
			}
		} else if (teamB.playerIsEmployee(id)){
			for (int i = 0; i < dressingRoomB.length && !isNull; i = i+2) {
				for (int j = 0; j < dressingRoomB[0].length && !isNull; j = j + 2) {
					if (dressingRoomB[i][j] == null) {
						dressingRoomB[i][j] = mockPlayer;
						isNull = true;
					}
				}
			}
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void removePlayerFromDr(String id) {
	boolean found = false;
		if (teamA.playerIsEmployee(id)) {
			for (int i = 0; i < dressingRoomA.length && !found; i = i+2) {
				for (int j = 0; j < dressingRoomA[0].length && !found; j = j+2) {
					if (dressingRoomA[i][j] != null && dressingRoomA[i][j].getId().equals(id)) {
						dressingRoomA[i][j] = null;
						found = true;
					}
				}
			}
		} else if (teamB.playerIsEmployee(id)) {
			for (int i = 0; i < dressingRoomB.length && !found; i = i+2) {
				for (int j = 0; j < dressingRoomB[0].length && !found; j = j+2) {
					if (dressingRoomB[i][j] != null && dressingRoomB[i][j].getId().equals(id)) {
						dressingRoomB[i][j] = null;
						found = true;
					}
				}
			}
		}
	}

	/**
	*
	*
	*
	*
	*/

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
	
	/**
	*
	*
	*
	*
	*/
	
	public String showInDressingRoom() {
		String outA = "";
		String outB = "";
		for (int i = 0; i < dressingRoomA.length; i++) {
			for (int j = 0; j < dressingRoomA[0].length; j++) {
				if (dressingRoomA[i][j] != null) {
					outA += dressingRoomA[i][j].getName() + "\t";
				} else {
					outA += "Null" + "\t"; 
				}
			}
			
			outA += "\n";
		}
		
		for (int i = 0; i < dressingRoomB.length; i++) {
			for (int j = 0; j < dressingRoomB[0].length; j++) {
				if (dressingRoomB[i][j] != null) {
					outB += dressingRoomB[i][j].getName() + "\t";
				} else {
					outB += "Null" + "\t"; 
				}
			}
			
			outB += "\n";
		}
		
		return outA + "\n" + outB;
	}
	
	// --------------------- Overloaded methods --------------------- //

	/**
	*
	*
	*
	*
	*/
	
	public void addEmployee(String name, String id, double salary, String state, int yearsOfExperience, int managerOfTeams, int wonChampionships) {
		MainCoach mcMock = new MainCoach(name, id, salary, state, yearsOfExperience, managerOfTeams, wonChampionships);
		payroll.add(mcMock);
		System.out.println(mcMock.toString());
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addEmployee(String name, String id, double salary, String state, int yearsOfExperience, boolean wasPlayer, String expertise) {
		Assistant acMock = new Assistant(name, id, salary, state, yearsOfExperience, wasPlayer, expertise);
		payroll.add(acMock);
		System.out.println(acMock.toString());
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addEmployee(String name, String id, double salary, String state, int shirtNumber, int numberOfGoals, double averageRating, String position) {
		Player plMock = new Player(name, id, salary, state, shirtNumber, numberOfGoals, averageRating, position);
		payroll.add(plMock);
		System.out.println(plMock.toString());
	}
	
	/**
	*
	*
	*
	*
	*/

	public void updateEmployee(String id, int wonChamp, int manager) {
		MainCoach mockCoach = (MainCoach)payroll.get(searchEmployeeById(id));
		if (wonChamp != -1) {
			mockCoach.setChampionships(wonChamp);
		} else if (manager != -1) {
			mockCoach.setManagerOfTeams(manager);
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void updateEmployee(String id, String name, double salary, String state) {
		Employee mockEmployee = payroll.get(searchEmployeeById(id));
		if (name != null) {
			mockEmployee.setName(name);
		} else if (salary != 0) {
			mockEmployee.setSalary(salary);
		} else if (state != null) {
			mockEmployee.setState(state);
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void updateEmployee(String id, int shirtNum, double averageRating, String position) {
		Player mockPl = (Player)payroll.get(searchEmployeeById(id));
		if (shirtNum != -1) {
			mockPl.setShirtNumber(shirtNum);
		} else if (averageRating != -1) {
			mockPl.setAverageRating(averageRating);
		} else if (position != null) {
			mockPl.setPosition(position);
		}
		
	}
	
	// ------------------------------------------------------------------
	
	// --------------------- toString methods --------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	public String employeesToString() {
		String out = "\n---- Employees ----\n";
		for (int i = 0; i < payroll.size(); i++){
			out += payroll.get(i).toString()  + "\n";
		}
		return out;
	}
	
	/**
	*
	*
	*
	*
	*/
	
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
	
	/**
	*
	*
	*
	*
	*/
	
	public String printClubInfo() { // Validar cuando estan vacios los array
		
		String out = "";
		out += "\nClub name: " + clubName + "\n" +
		"NIT: " + nit + "\n" +
		"Foundation date: " + foundationDate + "\n" +
		"Employees: " + payroll.toString() + "\n" + "Teams: " + "\n";
		if (teamA != null) {
			out += teamA.getTeamName() + ", ";
		}
		if (teamB != null) {
			out += teamB.getTeamName() + "\n";
		}
		
		return out;
	}
	
	// To String de prueba ////////////////////
	
	/**
	*
	*
	*
	*
	*/
	
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