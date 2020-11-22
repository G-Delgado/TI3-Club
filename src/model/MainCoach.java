package model;

public class MainCoach extends Coach {
	private int managerOfTeams;
	private int wonChampionships;
	
	public MainCoach (String name, String id, double salary, String state, int yearsOfExperience, int managerOfTeams, int wonChampionships) {
		super(name, id, salary, state, yearsOfExperience);
		this.managerOfTeams = managerOfTeams;
		this.wonChampionships = wonChampionships;
	}
	
	public double calculateMarketPrice() {
		return 0;
	}
	
	public double calculateStars() {
		return 0;
	}
}