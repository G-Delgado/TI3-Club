package ui;

import java.util.Scanner;
import model.Club;

public class Main {
	private Scanner in;
	private Club sapeClub;
	
	public Main() {
		in = new Scanner(System.in);
	}
	
	public static void main(String args[]) {
		Main ppal = new Main();
		int opt = 0;
		do {
			opt = ppal.showMenu();
			ppal.executeOperation(opt);
		} while (opt != 0);
		
	}
	
	public int showMenu() {
		int option = 0;
		System.out.println("\nWhat do you want to do?\n" +
		"(1) Create club\n" +
		"(2) Hire employee\n" +
		"(3) Fire employee\n" +
		"(4) Add an employee to a team\n" +
		"(5) Remove an employee from a team\n" +
		"(6) Update an employee information\n" +
		"(7) Show employees information\n" +
		"(8) Show teams information\n" +
		"(9) Add alignment to a team\n" +
		"(10) Move coach to an office\n" +
		"(11) Move player to a dressing room\n"+
		"(12)\n" +
		"(13)\n" +
		"(14) Show the club information\n" +
		"(15) Show coachs location in the office\n" +
		"(16) Show players location in the dressing rooms\n" +
		"(0) To exit\n");
		option = in.nextInt();
		in.nextLine();
		return option;
	}
	
	public void executeOperation(int opt) {
		switch (opt) {
			case 1:
				createClub();
				break;
			case 2:
				hireEmployeeMenu();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				System.out.println("\nExiting...\n");
				break;
			default:
				System.out.println("\nThis option is not valid\n");
				break;
		}
	}
	
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
	
	public void hireEmployeeMenu() {
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
	}
	
	public void hireEmployeeOperation(int opt) {
		int yearsOfExperience = 0;
		System.out.println("Enter the name of the employee");
		String name = in.nextLine();
		System.out.println("Enter his id A#### (Players), E#### (Coachs)");
		String id = in.nextLine();
		System.out.println("Enter the salary");
		double salary = in.nextDouble();
		in.nextLine();
		System.out.println("Enter the state of the employe (Active or Inactive)");
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
				System.out.println("Was a player in former years? 'Si o no' ");
				boolean wasPlayer = in.next().toLowerCase() == "si" ?  true : false;
				System.out.println("What was his expertise? Ofensive\nDefensive\nController\nLab Plays");
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
				System.out.println("Enter the position of the player. Goalkeeper\nDefender\nMidfield\nStricker");
				String position = in.nextLine();
				position = position.replaceAll(" ", "").toUpperCase();
				sapeClub.addEmployee(name, id, salary, state, shirtNumber, numberOfGoals, averageRating, position);
				break;
			default:
				System.out.println("\nThis option is not valid\n");
				break;
		}
	}
}