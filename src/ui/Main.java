package ui;

import java.util.Scanner;
import model.Club;

public class Main {
	// -------- Atributes and relations -------- //
	private Scanner in; // Scanner used to write information in the console
	private Club sapeClub; // Club, the management class, which is created when the user desires to.s
	// --------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	/**
	* Main constructor. Defines the club as null and instantiates the Scanner. <br>
	* pre: <br>
	* pos: sapeClub takes the value of null and a scanner is instantiated.<br>
	*/
	
	public Main() {
		sapeClub = null;
		in = new Scanner(System.in);
	}
	
	// ----------------------------------------------------------
	
	// --------------------- Entry of the program --------------------- //
	
	/**
	* It's the entry of the program.
	* pre: <br>
	* pos: <br>
	*
	*/
	
	public static void main(String args[]) {
		Main ppal = new Main();
		int opt = 0;
		do {
			opt = ppal.showMenu();
			ppal.executeOperation(opt);
		} while (opt != 0);
		
	}
	
	// -------------------------------------------------------------------
	
	// --------------------- Methods --------------------- //
	
	/**
	* Displays the menu with all the available options and asks for the user to choose one. <br>
	* pre: <br>
	* pos: <br>
	* @return option. Number that represents the chosen option.
	*/
	
	
	public int showMenu() {
		int option = 0;
		System.out.println("\nWhat do you want to do?\n" +
		"(1) Create club\n" +
		"(2) Hire employee\n" +
		"(3) Fire employee\n" +
		"(4) Create a team\n" + // Prob  I should add delete a team.
		"(5) Add an employee to a team\n" +
		"(6) Remove an employee from a team\n" +
		"(7) Update an employee's information\n" +
		"(8) Show employees information\n" +
		"(9) Show teams information\n" +
		"(10) Add alignment to a team\n" +
		"(11) Move coach to an office\n" +
		"(12) Move player to a dressing room\n"+
		"(13) Remove coach from an office\n" +
		"(14) Remove player from a dressing room\n" +
		"(15) Show the club information\n" +
		"(16) Show coachs location in the office\n" +
		"(17) Show players location in the dressing rooms\n" +
		"(0) To exit\n");
		option = in.nextInt();
		in.nextLine();
		return option;
	}
	
	/**
	* With the chosen option executes the desired method. <br>
	* pre: For a method to be called, the opt must be between 1 and 17.<br>
	* pos: <br>
	* @param opt. Represents the option chosen that comes from the showMenu method.
	*/
	
	public void executeOperation(int opt) {
		switch (opt) {
			case 1:
				createClub();
				break;
			case 2:
				hireEmployeeMenu();
				break;
			case 3:
				fireEmployeeMain();
				break;
			case 4:
				createTeam();
				break;
			case 5:
				addEmployeeToTeam();
				break;
			case 6:
				removeEmployeeFromTeam();
				break;
			case 7:
				// Need to finish this part
				updateEmployeeMenu();
				break;
			case 8:
				printEmployees();
				break;
			case 9:
				printTeams();
				break;
			case 10:
				//--- prob done
				addAlignment();
				break;
			case 11:
				addToOffice();
				break;
			case 12:
				addToDressingRoom();
				break;
			case 13:
				//--- prob done
				removeFromOffice();
				break;
			case 14:
				//--- prob done
				removeFromDr();
				break;
			case 15:
				printClub();
				break;
			case 16:
				showLocationInOffice();
				break;
			case 17:
				showLocationInDr();
				break;
			case 0:
				System.out.println("\nExiting...\n");
				break;
			default:
				System.out.println("\nThis option is not valid\n");
				break;
		}
	}
	
	/**
	* Asks the user to fill the data of the Club. Name, NIT and Foundation Date and creates a club. <br>
	* pre: The club must be equals to null<br>
	* pos: When a club with the data inserted is created, sapeClub will become that Club.<br>
	*/
	
	public void createClub() {
		if (sapeClub == null) {
			System.out.println("Enter the name of the club");
			String name = in.nextLine();
			System.out.println("Enter the NIT of the club");
			int nit = in.nextInt();
			in.nextLine();
			System.out.println("Enter its foundation date");
			String foundationDate = in.nextLine();
			
			sapeClub = new Club(name, nit, foundationDate);
		} else {
			System.out.println("The club has been created already");
		}
	}
	
	/**
	* Displays the menu of the possible employees to hire and asks the user to choose one. <br>
	* pre: <br>
	* pos: <br>
	*/
	
	public void hireEmployeeMenu() {
		if (sapeClub != null) {
			int opt = 0;
			do {
				System.out.println("\nWhat type of employee do you want to hire?\n" +
				"(1) Main coach\n" +
				"(2) Assistant coach\n" +
				"(3) Player\n" +
				"(0) To exit\n");
				opt = in.nextInt();
				in.nextLine();
				if (opt !=0) {
					hireEmployeeOperation(opt);
				}
			} while (opt !=0);
		} else {
			System.out.println("\n------ You have not created the club yet ------\n");
		}
		
	}
	
	/**
	* Asks for the user to fill the data of an employee and then, with the chosen option, to fill either a Main Coach, Assistant or Player data. <br>
	* pre: opt must be between 1 and 3.<br>
	* pos: <br>
	* @param opt. Represents the chosen option that comes from the hireEmployeeMenu method.
	*/
	
	public void hireEmployeeOperation(int opt) {
		int yearsOfExperience = 0;
		System.out.println("Enter the name of the employee");
		String name = in.nextLine();
		System.out.println("Enter his id J#### For Players.  E#### or coachs and assistants");
		String id = in.nextLine();
		id = id.toUpperCase();
		System.out.println("Enter the salary");
		double salary = in.nextDouble();
		in.nextLine();
		System.out.println("Enter the state of the employee (Active or Inactive)");
		String state = in.nextLine();
		state = state.replaceAll(" ", "").toUpperCase();
		
		if (opt == 1 || opt == 2) {
			System.out.println("Enter the years of experience");
			yearsOfExperience = in.nextInt();
			in.nextLine();
		}
		
		switch(opt) {
			case 0:
				System.out.println("\nReturning to the main menu...\n");
				break;
			case 1:
				System.out.println("How many teams does he manage?");
				int managerOfTeams = in.nextInt();
				in.nextLine();
				System.out.println("How many championships have he won?");
				int wonChampionships = in.nextInt();
				in.nextLine();
				sapeClub.addEmployee(name, id, salary, state, yearsOfExperience, managerOfTeams, wonChampionships);
				break;
			case 2:
				System.out.println("Was a player in former years? 'Yes or No' ");
				boolean wasPlayer = in.next().toLowerCase().equals("yes") ?  true : false;
				in.nextLine();
				System.out.println("What was his expertise? \n- Offensive\n- Defensive\n- Controller\n- Lab Plays\n");
				String expertise = in.nextLine();
				expertise = expertise.replaceAll(" ", "").toUpperCase();
				sapeClub.addEmployee(name, id, salary, state, yearsOfExperience, wasPlayer, expertise);
				break;
			case 3:
				System.out.println("Enter the shirt number");
				int shirtNumber = in.nextInt();
				in.nextLine();
				System.out.println("Enter the number of goals scored");
				int numberOfGoals = in.nextInt();
				in.nextLine();
				System.out.println("Enter the average rating of the player");
				double averageRating = in.nextDouble();
				in.nextLine();
				System.out.println("Enter the position of the player. \n- Goalkeeper\n- Defender\n- Midfield\n- Stricker\n");
				String position = in.nextLine();
				position = position.replaceAll(" ", "").toUpperCase();
				sapeClub.addEmployee(name, id, salary, state, shirtNumber, numberOfGoals, averageRating, position);
				break;
			default:
				System.out.println("\nThis option is not valid\n");
				break;
		}
	}

	/**
	* Asks for the id of the employee to fire <br>
	* pre: The club must be defined<br>
	* pos: <br>
	*/

	public void fireEmployeeMain() {
		if (sapeClub != null) {
			System.out.println("Which is the id of the employee to fire?");
			String id = in.nextLine();		
			sapeClub.fireEmployee(id);
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	/**
	* Asks for the data to create a Team. <br>
	* pre: The club must be defined. <br>
	* pos: <br>
	*/
	
	public void createTeam() {
		if (sapeClub != null) {
			System.out.println("Which team do you want it to be, 'A' or 'B'?");
			String option = in.next();
			in.nextLine();
			option = option.toUpperCase();
			
			System.out.println("Which is the name of the team?");
			String teamName = in.nextLine();
			
			sapeClub.createTeam(option.charAt(0), teamName);
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	/**
	* Asks for the id of an employee and adds him to the selected team. <br>
	* pre: The club must be defined and there should be an employee with the written id.<br>
	* pos: <br>
	*/
	
	public void addEmployeeToTeam() {
		if (sapeClub != null) {
			
			System.out.println("Enter the id of the employee to add");
			String id = in.nextLine();
			System.out.println("Enter the team you are going to add him to: 'A' or 'B'");
			char team = in.next().charAt(0);
			
			sapeClub.addEmpToTeam(id, team);
			
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	/**
	* Asks for the id of an employee and removes it from the selected team. <br>
	* pre: The club must be defined and there should be an employee with the written id.<br>
	* pos: <br>
	*/
	
	public void removeEmployeeFromTeam() {
		if (sapeClub != null) {
			System.out.println("Enter the id of the employee");
			String id = in.nextLine();
			System.out.println("Enter which team is the employee at:  'A' or 'B'");
			char team = in.next().charAt(0);
			
			sapeClub.removeFromTeam(id, team);
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	/**
	* Asks for the id of an employee and the atribute to update. <br>
	* pre: The club must be defined and there should be an employee with the written id.<br>
	* pos: <br>
	*/
	
	public void updateEmployeeMenu() {
		if (sapeClub != null) {
			int opt = 0;
			System.out.println("Enter the id of the employee to update its data");
			String id = in.next();
			
			if (id.toUpperCase().charAt(0) == 'E' || id.toUpperCase().charAt(0) == 'J' ) {
				do {
					System.out.println("\nWhat do you want to update?\n" + 
					"(1) Name\n" +
					"(2) Salary\n" +
					"(3) State\n" +
					"(4) Won championships (For main coachs)\n" +
					"(5) Manager of teams (For main coachs)\n" +
					"(6) Shirt number (For players)\n" +
					"(7) Average rating (For players)\n" +
					"(8) Position (For players)\n" +
					"(0) To exit\n");
					
					opt = in.nextInt();
					in.nextLine();
					if (opt != 0) {
						updateEmployeeMain(id, opt);
					}
				} while(opt !=0);
			} else {
				System.out.println("\nThis id does not belongs to any employee\n");
			}
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	/**
	* Receives the id and the selected option from the removeEmployeeFromTeam method and updates the selected atribute. <br>
	* pre: The club must be defined and there shoudl be an employee with the written id.<br>
	* pos: <br>
	* @param id. Represents the id of the employee <br>
	* @param opt. Represents the chosen option to update
	*/
	
	public void updateEmployeeMain(String id, int opt) {
		if (sapeClub != null) {
			switch (opt) {
				case 1:
					// Name
					System.out.println("Enter the new name of the employee");
					String name = in.nextLine();
					sapeClub.updateEmployee(id, name, 0, null);
					break;
				case 2:
					// Salary
					System.out.println("Enter the new salary of the employee");
					double salary = in.nextDouble();
					in.nextLine();
					sapeClub. updateEmployee(id, null, salary, null);
					break;
				case 3:
					// State
					System.out.println("Enter the state of the employee 'Active' or 'Inactive' ");
					String state = in.nextLine().replaceAll(" ", "").toUpperCase();
					sapeClub.updateEmployee(id, null, 0, state);
					break;
				case 4:
					// Won championships (main coach)
					if (id.toUpperCase().charAt(0) == 'E') {
						System.out.println("Enter the amount of won championships of the coach");
						int wonChamp = in.nextInt();
						in.nextLine();
						sapeClub.updateEmployee(id, wonChamp, -1);
					} else {
						System.out.println("This id does not belong to a Main Coach");
					}
					break;
				case 5:
					// Manager of teams (main coach)
					if (id.toUpperCase().charAt(0) == 'E') {
						System.out.println("Enter the amount of teams the coach manages");
						int manager = in.nextInt();
						in.nextLine();
						sapeClub.updateEmployee(id, -1, manager);
					} else {
						System.out.println("This id does not belong to a Main Coach");
					}
					break;
				case 6:
					// Shirt number (player)
					if (id.toUpperCase().charAt(0) == 'J') {
						System.out.println("Enter the shirt number of the player");
						int shirtNum = in.nextInt();
						in.nextLine();
						sapeClub.updateEmployee(id, shirtNum, -1, null);
					} else {
						System.out.println("This id does not belong to a Player");
					}
					
					break;
				case 7:
					// Average rating (player)
					if (id.toUpperCase().charAt(0) == 'J') {
						System.out.println("Enter the average rating of the player");
						double averageRating = in.nextDouble();
						in.nextLine();
						sapeClub.updateEmployee(id, -1, averageRating, null);
					} else {
						System.out.println("This id does not belong to a Player");
					}
					break;
				case 8:
					// Position (player)
					if (id.toUpperCase().charAt(0) == 'J') {
						System.out.println("Enter the position of the player. \n- Goalkeeper\n- Defender\n- Midfield\n- Stricker\n");
						String position = in.nextLine().replaceAll(" ", "").toUpperCase();
						sapeClub.updateEmployee(id, -1, -1, position);
					} else {
						System.out.println("This id does not belong to a Player");
					}
					break;
			}
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	/**
	* DOOOOOOOOOOOOOOOOOOINNNNNNNNNNNNNNNNNNGGGGGGGGGGGGGGGGG THISSSSSSSSSSSSSSSSSSS LATEERRRRRRRRRRRRRRRRRRRRRR
	*
	*
	*FDEDFDHGFDHFDHMGNESDRJGNERJIKENDRBIKGBENDBFKBGFIKGBDFKGBFDGBDSKGKD
	*/
	
	public void addAlignment() { // Should I also be able to print the formation??
		if (sapeClub != null) {
			System.out.println("Which team do you want to add it to? 'A' or 'B'");  // There is an error that i cant get to notice
			char team = in.nextLine().toUpperCase().charAt(0);
			
			System.out.println("Enter the date of this alignment");
			String date = in.nextLine();
			
			System.out.println("Enter the formation. Example. 4-4-2\n\n" + 
			"0  0  0  0  0  0  0\n" +
			"0  0  0  0  0  0  0\n" +
			"0  1  0  0  0  1  0\n" +
			"0  0  0  0  0  0  0\n" +
			"0  0  0  0  0  0  0\n" +
			"0  1  1  0  1  1  0\n" +
			"0  0  0  0  0  0  0\n" +
			"0  0  0  0  0  0  0\n" +
			"0  1  1  0  1  1  0\n" +
			"0  0  0  0  0  0  0\n" +
			"\nREMEMBER, THERE ARE ONLY 10 PLAYERS IN THE FORMATION AS THE GOALKEEPER IS NOT BEING COUNTED.\n" +
			"So you can do 4-2-2-2, but can not do 4-5-8-1. As the summatory of these numbers surpasses 10");
			
			String formation = in.nextLine();
			
			System.out.println("Enter the tactic of the alignment\n" +
			"Possesive\n" +
			"Counter attack\n" +
			"High pressure\n" +
			"Default\n");
			
			String tactic = in.nextLine();
			tactic = tactic.replaceAll(" ","").toUpperCase();
			
			int sum = 0;
			boolean error = false;
			String errorMessage = "";
			String[] formationNums = formation.split("-");
			if (formationNums.length <= 10) {
				for (int i = 0; i < formationNums.length && !error; i++) { // TOO MANY CONDITIONALS
					if (Integer.parseInt(formationNums[i]) <= 7) {
						sum += Integer.parseInt(formationNums[i]);
					} else {
						error = true;
						errorMessage = "One position of the formation surpasses 7";
					}
				}
				
				if (sum > 10) {
				System.out.println("The formation surpasses the 10 players");
				} else if (sum > 0 && sum <= 10) {
					if (team == 'A' || team == 'B') {
						if (sapeClub != null) {
							sapeClub.addAlignmentToTeam(team, date, formationNums, tactic);
						} else {
							errorMessage = "The club has not been created";
						}
					} else {
						System.out.println("The entered team is not valid");
					}
				} else {
					System.out.println("\nYou have introduced a wrong formation");
				}
				
			} else {
				errorMessage = "There are more than 10 positions";
			}
				
			if (errorMessage != "") {
				System.out.println("\n" + errorMessage + " !!!\n");
			}
		} else {
			System.out.println("The club has not been created");
		}
		
			
	}
	
	/**
	* Asks for the id of the coach and adds him to the Office Sector. <br>
	* pre: The club must be defined and the id should belong to a coach.<br>
	* pos: <br>
	*/
	
	public void addToOffice() {
		if (sapeClub != null) {
			System.out.println("Enter the id of the coach");
			String id = in.nextLine();
			if (id.charAt(0) == 'E') {
				sapeClub.addEmpToOffice(id);
			} else {
				System.out.println("This id does not belong to any coach");
			}
			
		} else {
			System.out.println("\nThe club has not been created\n");
		}
		
	}
	
	/**
	* Asks for the id of the coach and removes him from the Office Sector. <br>
	* pre: The club must be defined and the id should belong to a coach.<br>
	* pos: <br>
	*/
	
	public void removeFromOffice() {
		if (sapeClub != null) {
		
			System.out.println("Enter the id of the coach to remove from the office");
			String id = in.next();
			
			if (id.charAt(0) == 'E') {
				sapeClub.removeCoachFromOffice(id);
			} else {
				System.out.println("The id doest not belong to any coach");
			}
		} else {
			System.out.println("\nThe club has not been created\n");
		}
		
	}
	
	/**
	* Prints the location of the coaches in the office. <br>
	* pre: The club must be defined<br>
	* pos: <br>
	*/
	
	public void showLocationInOffice() {
		if (sapeClub != null) {
			System.out.println(sapeClub.showInOffice());
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	/**
	* Asks for the id of the player and adds him to the Dressing Room. <br>
	* pre: The club must be defined and the id should belong to a player.<br>
	* pos: <br>
	*/
	
	public void addToDressingRoom() {
		if (sapeClub != null) {
			System.out.println("Enter the id of the player");
			String id = in.nextLine();
			if (id.charAt(0) == 'J') {
				sapeClub.addPlayerToDr(id);
			} else {
				System.out.println("This id does not belong to any player");
			}
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	/**
	* Asks for the id of the player and removes him from the Dressing Room. <br>
	* pre: The club must be defined and the id should belong to a player.<br>
	* pos: <br>
	*/
	
	public void removeFromDr() {
		if (sapeClub != null) {
			System.out.println("Enter the id of the player to remove from the dressing room");
			String id = in.next();
			
			if (id.charAt(0) == 'J') {
				sapeClub.removePlayerFromDr(id);
			} else {
				System.out.println("The id doest not belong to any player");
			}
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	/**
	* Prints the location of the players in the dressing rooms. <br>
	* pre: The club must be defined<br>
	* pos: <br>
	*/
	
	public void showLocationInDr() {
		if (sapeClub != null) {
			System.out.println(sapeClub.showInDressingRoom());
		} else {
			System.out.println("\nThe club has not been created\n");
		}
		
	}
	
	/**
	* Prints the employees with their atributes. <br>
	* pre: The club must be defined. <br>
	* pos: <br>
	*/
	
	public void printEmployees() {
		if (sapeClub != null) {
			System.out.println(sapeClub.employeesToString());
		} else {
			System.out.println("\nThe club has not been created\n");
		}
		
	}
	
	/**
	* Prints the teams with their atributes. <br>
	* pre: The club must be defined. <br>
	* pos: <br>
	*/
	
	public void printTeams() { 
		if (sapeClub != null) {
			System.out.println(sapeClub.teamsToString());
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	/**
	* Prints the club with their atributes and information. <br>
	* pre: The club must be defined. <br>
	* pos: <br>
	*
	*/
	
	public void printClub() {
		if (sapeClub != null) {
			System.out.println(sapeClub.printClubInfo());
		} else {
			System.out.println("\nThe club has not been created\n");
		}
	}
	
	// -----------------------------------------------------------------------
}