package model;

public class MainCoach extends Coach implements Profitable {
	
	// Relations 
	
	private int managerOfTeams;
	private int wonChampionships;
	
	// Constructor
	
	public MainCoach (String name, String id, double salary, String state, int yearsOfExperience, int managerOfTeams, int wonChampionships) {
		super(name, id, salary, state, yearsOfExperience);
		this.managerOfTeams = managerOfTeams;
		this.wonChampionships = wonChampionships;
	}
	
	// Getters and setters
	
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
	
	// Inherited methods from profitable interface
	
	public double calculateMarketPrice() {
		double marketPrice = (getSalary() * 10) + (getYearsOfExperience() * 100) + (wonChampionships * 50);
		return marketPrice;
	}
	
	public double calculateStars() {
		double stars = 5 + (wonChampionships/10);
		return stars;
	}
	
	// Overrided methods
	
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