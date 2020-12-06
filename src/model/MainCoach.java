package model;

public class MainCoach extends Coach implements Profitable {
	
	// --------------------- Atributes and relations --------------------- // 
	
	private int managerOfTeams; // Represents the number of teams the coach manages.
	private int wonChampionships; // Represents the number of won championships the coach has.
	// ----------------------------------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	/**
	* MainCoach's constructor. <br>
	* pre: All the parameters must be defined. <br>
	* pos: The values of the corresponding atributes are now the ones passed by the parameters.<br>
	* @param name. Represents the name of the main coach. <br>
	* @param id. Represents the id of the main coach. <br>
	* @param salary. Represents the salary of the main coach. <br>
	* @param state. Represents the state of the main coach. <br>
	* @param yearsOfExperience. Represents the years of experience of the main coach. <br>
	* @param managerOfTeams. Represents the amount of teams managed by the main coach. <br>
	* @param wonChampionships. Represents the amount of wonChampionships with the main coach.
	*/
	
	public MainCoach (String name, String id, double salary, String state, int yearsOfExperience, int managerOfTeams, int wonChampionships) {
		super(name, id, salary, state, yearsOfExperience);
		this.managerOfTeams = managerOfTeams;
		this.wonChampionships = wonChampionships;
	}
	
	// -----------------------------------------------------------
	
	// --------------------- Getters and setters --------------------- //
	
	public int getManagerOfTeams() {
		return managerOfTeams;
	}
	
	public void setManagerOfTeams(int managerOfTeams) {
		this.managerOfTeams = managerOfTeams;
	}
	
	public int getWonChampionships() {
		return wonChampionships;
	}
	
	public void setChampionships(int wonChampionships) {
		this.wonChampionships = wonChampionships;
	}
	
	// --------------------- Inherited methods from profitable interface --------------------- //
	
	/**
	* Calculates and returns the market price of the main coach. <br>
	* pre: The salary, yearsOfExperience and wonChampionships must be defined. <br>
	* pos: <br>
	* @return marketPrice. A double that represents the main coach market price.
	*/
	
	public double calculateMarketPrice() {
		double marketPrice = (getSalary() * 10) + (getYearsOfExperience() * 100) + (wonChampionships * 50);
		return marketPrice;
	}
	
	/**
	* Calculates and returns the star level of the main coach. <br>
	* pre: The wonChampionships must be defined. <br>
	* pos : <br>
	* @return stars. A double that represents the star level of the main coach.
	*/
	
	public double calculateStars() {
		double stars = 5 + (wonChampionships/10);
		return stars;
	}
	
	// --------------------- Overrided methods --------------------- //
	
	/**
	* Returns a String that contains all the information of the main coach. <br>
	* pre: <br>
	* pos: <br>
	* @return out. A string that contains all the information of the main coach. <br>
	*/
	
	@Override
	public String toString() {
		String out = super.toString() + "Manager of teams: " + managerOfTeams + "\n" +
		"Won championships: " + wonChampionships + "\n" +
		"Market price: " + calculateMarketPrice() + "\n" +
		"Stars level: " + calculateStars() + "\n" +
		"-----------------------------------\n";		
		
		return out;
	}
}