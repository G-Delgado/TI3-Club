package ui;

import java.util.Scanner;
import model.Club;

public class Main {
	// -------- Atributes and relations -------- //
	private Scanner in;
	private Club sapeClub;
	// --------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	public Main() {
		sapeClub = null;
		in = new Scanner(System.in);
	}
	
	// ----------------------------------------------------------
	
	// --------------------- Entry of the program --------------------- //
	
	public static void main(String args[]) {
		Main ppal = new Main();
		int opt = 0;
		do {
			opt = ppal.showMenu();
			ppal.executeOperation(opt);
		} while (opt != 0);
		
	}
	
	// -------------------------------------------------------------------
	
	/**
	*
	*
	*
	*
	*/
	
	// --------------------- Methods --------------------- //
	
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
	*
	*
	*
	*
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
	*
	*
	*
	*
	*/
	
	public void createClub() {
		System.out.println("Enter the name of the club");
		String name = in.nextLine();
		System.out.println("Enter the NIT of the club");
		int nit = in.nextInt();
		in.nextLine();
		System.out.println("Enter its foundation date");
		String foundationDate = in.nextLine();
		
		sapeClub = new Club(name, nit, foundationDate);
	}
	
	/**
	*
	*
	*
	*
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
	*
	*
	*
	*
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
	*
	*
	*
	*
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
	*
	*
	*
	*
	*/
	
	public void createTeam() {
		System.out.println("Which team do you want it to be, 'A' or 'B'?");
		String option = in.next();
		in.nextLine();
		option = option.toUpperCase();
		
		System.out.println("Which is the name of the team?");
		String teamName = in.nextLine();
		
		sapeClub.createTeam(option.charAt(0), teamName);
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addEmployeeToTeam() {
		System.out.println("Enter the id of the employee to add");
		String id = in.nextLine();
		System.out.println("Enter the team you are going to add him to: 'A' or 'B'");
		char team = in.next().charAt(0);
		
		sapeClub.addEmpToTeam(id, team);
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void removeEmployeeFromTeam() {
		System.out.println("Enter the id of the employee");
		String id = in.nextLine();
		System.out.println("Enter which team is the employee at:  'A' or 'B'");
		char team = in.next().charAt(0);
		
		sapeClub.removeFromTeam(id, team);
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void updateEmployeeMenu() {
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
			System.out.println("This id does not belongs to any employee");
		}
	}
	
	public void updateEmployeeMain(String id, int opt) {
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
				System.out.println("Enter the amount of won championships of the coach");
				int wonChamp = in.nextInt();
				in.nextLine();
				sapeClub.updateEmployee(id, wonChamp, 0);
				break;
			case 5:
				// Manager of teams (main coach)
				System.out.println("Enter the amount of teams the coach manages");
				int manager = in.nextInt();
				in.nextLine();
				sapeClub.updateEmployee(id, 0, manager);
				break;
			case 6:
				// Shirt number (player)
				System.out.println("Enter the shirt number of the player");
				int shirtNum = in.nextInt();
				in.nextLine();
				sapeClub.updateEmployee(id, shirtNum, 0, null);
				break;
			case 7:
				// Average rating (player)
				System.out.println("Enter the average rating of the player");
				double averageRating = in.nextDouble();
				in.nextLine();
				sapeClub.updateEmployee(id, 0, averageRating, null);
				break;
			case 8:
				// Position (player)
				System.out.println("Enter the position of the player. \n- Goalkeeper\n- Defender\n- Midfield\n- Stricker\n");
				String position = in.nextLine().replaceAll(" ", "").toUpperCase();
				sapeClub.updateEmployee(id, 0, 0, position);
				break;
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addAlignment() { // Should I also be able to print the formation??
		
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
			
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addToOffice() {
		System.out.println("Enter the id of the coach");
		String id = in.nextLine();
		if (id.charAt(0) == 'E') {
			sapeClub.addEmpToOffice(id);
		} else {
			System.out.println("This id does not belong to any coach");
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void removeFromOffice() {
		System.out.println("Enter the id of the coach to remove from the office");
		String id = in.next();
		
		if (id.charAt(0) == 'E') {
			sapeClub.removeCoachFromOffice(id);
		} else {
			System.out.println("The id doest not belong to any coach");
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void showLocationInOffice() {
		System.out.println(sapeClub.showInOffice());
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void addToDressingRoom() {
		System.out.println("Enter the id of the player");
		String id = in.nextLine();
		if (id.charAt(0) == 'J') {
			sapeClub.addPlayerToDr(id);
		} else {
			System.out.println("This id does not belong to any player");
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void removeFromDr() {
		System.out.println("Enter the id of the player to remove from the dressing room");
		String id = in.next();
		
		if (id.charAt(0) == 'J') {
			sapeClub.removePlayerFromDr(id);
		} else {
			System.out.println("The id doest not belong to any player");
		}
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void showLocationInDr() {
		System.out.println(sapeClub.showInDressingRoom());
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void printEmployees() {
		System.out.println(sapeClub.employeesToString());
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void printTeams() { 
		System.out.println(sapeClub.teamsToString());
	}
	
	/**
	*
	*
	*
	*
	*/
	
	public void printClub() {
		System.out.println(sapeClub.printClubInfo());
	}
	
	// -----------------------------------------------------------------------
}