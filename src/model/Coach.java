package model;

public abstract class Coach extends Employee {
	
	// Relations
	
	private int yearsOfExperience;
	
	// Constructor
	
	public Coach (String name, String id, double salary, String state, int yearsOfExperience) {
		super(name, id, salary, state);
		this.yearsOfExperience = yearsOfExperience;
	}
	
	// Getters and Setters
	
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	// Overrided Methods
	
	@Override // I need to add to the toString methods the MarketPrice and the Stars
	public String toString() {
		String out = super.toString() + "Years of experience: " + yearsOfExperience + "\n";
		return out;
	}
}