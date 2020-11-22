package model;

public abstract class Coach extends Employee {
	private int yearsOfExperience;
	
	public Coach (String name, String id, double salary, String state, int yearsOfExperience) {
		super(name, id, salary, state);
		this.yearsOfExperience = yearsOfExperience;
	}
}