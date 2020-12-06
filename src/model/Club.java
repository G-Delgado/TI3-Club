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
	* Club's constructor.
	* pre: The clubName, nit and foundationDate must be defined.<br>
	* pos: The values of clubName, nit and foundationDate are now defined in the club. the teams are initialized in null and the ArrayLists and each Matrix are initialized.<br>
	* @param clubName. Represents the name of the club. <br>
	* @param nit. Represents the NIT of the club. <br>
	* @param foundationDate. Represents the foundationDate of the club.
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

	// --------------------- Methods ---------------------------- //
	
	/**
	* Searches an employee by its id and fires him. Also, removes him from the teams, etc.
	* pre: The id must belong to an employee<br>
	* pos: The position in the ArrayList of the employee will be taken by the next employee.<br>
	* @param id. Represents the id of the employee to fire.
	*/
	
	public void fireEmployee(String id) { 
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
					found = teamA.playerIsEmployee(id);
				}

				if (teamB != null && !found) {
					found = teamB.playerIsEmployee(id);
				}
		} else {
			if (teamA.getMainCoach() != null && id.equals(teamA.getMainCoach().getId())) {
				teamA.setMainCoach(null);
			} else if (teamB.getMainCoach() != null && id.equals(teamB.getMainCoach().getId())) {
				teamA.setMainCoach(null);
			} else {
				if (teamA != null) {
					found = teamA.coachIsEmployee(id);
				}
				
				if (teamB != null && !found) {
					found = teamB.coachIsEmployee(id);
					}
				}
			}
		} else {
			System.out.println("Neither of the two teams have been created yet");
		}
	}
	
	/**
	* Searchs the employee by a given id and returns the index of the employee. <br>
	* pre: The id must belong to an employee<br>
	* pos: <br>
	* @param id. The id of the employee to search <br>
	* @return index. Returns the index of the employee in the ArrayList.
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
	* Creates a team with the needed information. <br>
	* pre: The teamName should not be an Empty String and opt should be 'A' or 'B'. <br>
	* pos: Creates a team and assigns it to whether teamA or teamB. <br>
	* @param opt. Represents whether the team to create is the A or B. <br>
	* @param teamName. Represents the name of the team to create.
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

	/*
	TO MAKEEEEEEEEEEEEEEEEEEEEEEEEEE
	*/
	/**
	* I WILL DO THE ALIGNMENT LATER ON. ;)
	*
	*
	* @param team.
	* @param date.
	* @param formation.
	* @param tactic.
	* @return result.
	*/

	public String addAlignmentToTeam(char team, String date, String[] formation, String tactic) { 
		
		String result = "";
		
		
		// Convert the formation to a matrix
		int[][] formationMatrix = new int[10][7];
		int cont = 1;
		int start = 0;
		int verticalJump = formationMatrix.length / formation.length;
		for (int i = formationMatrix.length - verticalJump; i >= 0 && cont <= formation.length; i = i - verticalJump){
			cont++;
			fillFormation(formationMatrix, i, formation, start);
			start++;
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
	
	public void fillFormation(int[][] formMatrix, int row, String[] formation, int start) {
		int i = 0;
		int limitCol = 7;
		int actualElement = 0;
		boolean done = false;
		for (int j = start; j < formation.length && !done; j++) {
			actualElement = Integer.parseInt(formation[j]);
			if (actualElement % 2 == 0) {
					i = 2;
					while (actualElement > 0) {
					formMatrix[row][i] = 1;
						if (i == 2) {
							i = 4;
						} else if (i == 4) {
							i = 1;
						} else if (i == 1) {
							i = 5;
						} else if (i == 5) {
							i = 0;
						} else if (i == 0) {
							i = 6;
						}
						actualElement--;
					}
					done = true;
			} else {
					i = 3;
					if (actualElement == 1) {
						formMatrix[row][i] = 1;
						actualElement--;
						done = true;
					} else {
						while (actualElement > 0) {
							formMatrix[row][i] = 1;
							if (i == 2) {
								i = 4;
							} else if (i == 4) {
								i = 1;
							} else if (i == 1) {
								i = 5;
							} else if (i == 5) {
								i = 0;
							} else if (i == 0) {
								i = 6;
							}
							if (i == 3) {
								i = 2;
							}
							actualElement--;
						}
						done = true;
					}
					
				
			}
		}
		
		
	}

	/**
	* Adds an employee to a chosen team. <br>
	* pre: The id must belong to an employee and the team should be whether 'A' or 'B'.<br>
	* pos: The employee will be added to the selected team.<br>
	* @param id. Represents the id of the employee. <br>
	* @param team. Represents the team to which we are adding the employee.
	*/

	public void addEmpToTeam(String id, char team) { 
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
				if (mockPlayer != null && (!teamA.playerIsEmployee(mockPlayer.getId())) && !teamB.playerIsEmployee(mockPlayer.getId())) {
					teamA.addEmployee(mockPlayer);
				} else if (mockMc != null && (!teamA.coachIsEmployee(mockMc.getId()) && !teamB.coachIsEmployee(mockMc.getId()))) {
					teamA.addEmployee(mockMc);
				} else if (mockAs != null && (!teamA.coachIsEmployee(mockAs.getId()) && !teamB.coachIsEmployee(mockAs.getId()))){
					teamA.addEmployee(mockAs);
				}
				break;
			case 'B':
				if (mockPlayer != null && (!teamB.playerIsEmployee(mockPlayer.getId())) && !teamA.playerIsEmployee(mockPlayer.getId())) {
					teamB.addEmployee(mockPlayer);
				} else if (mockMc != null && (!teamB.coachIsEmployee(mockMc.getId()) && !teamA.coachIsEmployee(mockMc.getId()))) {
					teamB.addEmployee(mockMc);
				} else if (mockAs != null && (!teamB.coachIsEmployee(mockAs.getId()) && !teamA.coachIsEmployee(mockAs.getId()))){
					teamB.addEmployee(mockAs);
				}
				break;
		}
	}
	
	/**
	* Removes an employee from a team. <br>
	* pre: The id must belong to an employee and the team shoudl be whether 'A' or 'B'<br>
	* pos: The employee wll be removed from the selected team. <br>
	* @param id. Represents the id of the employee. <br>
	* @param team. Represents the team from which we are removing the employee.
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
	* Adds an employee to the office sector. <br>
	* pre: The id must belong to a Coach.<br>
	* pos: The employee will be added to the officeSector matrix. <br>
	* @param id. Represents the id of the employee.
	*/
	
	public void addEmpToOffice(String id) { 
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
	* Removes a coach from the office sector. <br>
	* pre: The id must belong to a Coach. <br>
	* pos: The coach will be removed from the officeSector matrix. <br>
	* @param id. Represents the id of the coach.
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
	* Adds a player to a dressing room depending on which team he is. <br>
	* pre: The id must belong to a Player<br>
	* pos: The player will be added to whether the dressingRoomA or dressingRoomB matrix.<br>
	* @param id. Represents the id of the player.
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
	* Removes a player from a dressing room depending on which team he is. <br>
	* pre: The id must belong to a Player<br>
	* pos: The player will be removed from whether the dressingRoomA or dressingRoomB matrix. <br>
	* @param id. Represents the id of the player.
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
	* Loops through the officeSector matrix and returns a String with the location of each coach in the office. <br>
	* pre: <br>
	* pos: <br>
	* @return out. A string with the location of each coach in the office.
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
	* Loops through both dressingRooms matrixs and returns a String with the location of each player in each dressing room. <br>
	* pre: <br>
	* pos: <br>
	* @return message. A string with the players in each dressing room.
	*/
	
	public String showInDressingRoom() { 
		String outA = "";
		String outB = "";
		String message = "";
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
		
		message = outA + "\n" + outB;
		
		return message;
	}
	
	// --------------------- Overloaded methods --------------------- //

	/**
	* Adds a new employee to the payroll. Employee that must be a Main Coach. <br>
	* pre: All the parameters must be defined.<br>
	* pos: A new employee of instance MainCoach is added to the payroll.<br>
	* @param name. Represents the name of the Main Coach. <br>
	* @param id. Represents the id of the Main Coach. <br>
	* @param salary. Represents the salary of the Main Coach. <br>
	* @param state. Represents the state of the Main Coach. <br>
	* @param yearsOfExperience. Represents the year of experience as a coach. <br>
	* @param managerOfTeams. Represents how many teams does the coach manages. <br>
	* @param wonChampionships. Represents the amount of won championships as a coach.
	*/
	
	public void addEmployee(String name, String id, double salary, String state, int yearsOfExperience, int managerOfTeams, int wonChampionships) {
		MainCoach mcMock = new MainCoach(name, id, salary, state, yearsOfExperience, managerOfTeams, wonChampionships);
		payroll.add(mcMock);
		System.out.println(mcMock.toString());
	}
	
	/**
	* Adds a new employee to the payroll. Employee that must be an Assistant. <br>
	* pre: All the parameters must be defined. <br>
	* pos: A new employee of instance Assistant is added to the payroll. <br>
	* @param name. Represents the name of the Assistant. <br>
	* @param id. Represents the id of the Assistant. <br>
	* @param salary. Represents the salary of the Assistant. <br>
	* @param state. Represents the state of the Assistant. <br>
	* @param yearsOfExperience. Represents the year of experience as a coach. <br>
	* @param wasPlayer. Represents whether the assistant was a player in the past. <br>
	* @param expertise. Represents the expertise of the assistant.
	*/
	
	public void addEmployee(String name, String id, double salary, String state, int yearsOfExperience, boolean wasPlayer, String expertise) {
		Assistant acMock = new Assistant(name, id, salary, state, yearsOfExperience, wasPlayer, expertise);
		payroll.add(acMock);
		System.out.println(acMock.toString());
	}
	
	/**
	* Adds a new employee to the payroll. Employee that must be a Player. <br>
	* pre: All the parameters must be defined. <br>
	* pos: A new employee of instance Player is added to the payroll. <br>
	* @param name. Represents the name of the Player. <br>
	* @param id. Represents the id of the Player. <br>
	* @param salary. Represents the salary of the Player. <br>
	* @param state. Represents the state of the Player. <br>
	* @param shirtNumber. Represents the number of the player's shirt. <br>
	* @param numberOfGoals. Represents the number of goals the player has made so far. <br>
	* @param averageRating. Represents the average rating of the player. <br>
	* @param position. Represents the position of the player.
	*/
	
	public void addEmployee(String name, String id, double salary, String state, int shirtNumber, int numberOfGoals, double averageRating, String position) {
		Player plMock = new Player(name, id, salary, state, shirtNumber, numberOfGoals, averageRating, position);
		payroll.add(plMock);
		System.out.println(plMock.toString());
	}
	
	/**
	* Updates an employee of instance MainCoach, depending on the parameters. <br>
	* pre: The atribute to update must be greater or equal to 0 <br>
	* pos: The selected atribute of the employee will be updated with the new value. <br>
	* @param id. Represents the id of the Main Coach. <br>
	* @param wonChamp. Represents the number of won championships to update. <br>
	* @param manager. Represents the number of teams managed by the main coach to update. 
	*/

	public void updateEmployee(String id, int wonChamp, int manager) {
		MainCoach mockCoach = (MainCoach)payroll.get(searchEmployeeById(id));
		if (wonChamp >= 0) {
			mockCoach.setChampionships(wonChamp);
		} else if (manager >= 0) {
			mockCoach.setManagerOfTeams(manager);
		}
	}
	
	/**
	* Updates any employee depending on the parameters. <br>
	* pre: The atribute to update must be whether different from null if it is an String, or different from 0 if it is a double. <br>
	* pos: The selected atribute of the employee will be updated with the new value. <br>
	* @param id. Represents the id of the Employee. <br>
	* @param name. Represents the new name of the Employee. <br>
	* @param salary. Represents the new salary of the employee. <br>
	* @param state. Represents the new state of the employee.
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
	* Updates an employee of instance Player depending on the parameters. <br>
	* pre: The atribute to update must be whether greater or equal to 0 if it is an int or a double or different from null if it is an String. <br>
	* pos: The selected atribute of the employee will be updated with the new value. <br>
	* @param id. Representes the id of the Player. <br>
	* @param shirtNum. Represents the new number of the player's shirt. <br>
	* @param averageRating. Represents the new average rating of the player. <br>
	* @param position. Representes the new position of the player. 
	*/
	
	public void updateEmployee(String id, int shirtNum, double averageRating, String position) {
		Player mockPl = (Player)payroll.get(searchEmployeeById(id));
		if (shirtNum >= 0) {
			mockPl.setShirtNumber(shirtNum);
		} else if (averageRating >= 0) {
			mockPl.setAverageRating(averageRating);
		} else if (position != null) {
			mockPl.setPosition(position);
		}
		
	}
	
	// ------------------------------------------------------------------
	
	// --------------------- toString methods --------------------- //
	
	/**
	* Returns a string with all the information of the employees in the payroll. <br>
	* pre: <br>
	* pos: <br>
	* @return out. a string that contains the information of all the employees.
	*/
	
	public String employeesToString() {
		String out = "\n---- Employees ----\n";
		for (int i = 0; i < payroll.size(); i++){
			out += payroll.get(i).toString()  + "\n";
		}
		return out;
	}
	
	/**
	 Returns a string with all the information of the teams in the club. <br>
	* pre: <br>
	* pos: <br>
	* @return out. A string that contains the information of the teams different from null.
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
	 Returns a string with all the information of the club. <br>
	* pre: <br>
	* pos: <br>
	* @return out. A string that contains the club information and the name of the teams different from null.
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
	
}