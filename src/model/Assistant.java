package model;

public class Assistant extends Coach {
	private boolean wasPlayer;
	private Expertise expertise;
	
	public Assistant (String name, String id, double salary, String state, int yearsOfExperience, boolean wasPlayer, String expertise) {
		super(name, id, salary, state, yearsOfExperience);
		this.wasPlayer = wasPlayer;
		this.expertise = Expertise.valueOf(expertise);
	}
}
