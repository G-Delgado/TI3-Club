package model;

public class Assistant extends Coach {
	
	// Relations
	
	private boolean wasPlayer;
	private Expertise expertise;
	
	// Constructor
	
	public Assistant (String name, String id, double salary, String state, int yearsOfExperience, boolean wasPlayer, String expertise) {
		super(name, id, salary, state, yearsOfExperience);
		this.wasPlayer = wasPlayer;
		this.expertise = Expertise.valueOf(expertise);
	}
	
	// Getters and Setters
	
	public boolean getWasPlayer() {
		return wasPlayer;
	}
	
	public void setWasPlayer(boolean wasPlayer) {
		this.wasPlayer = wasPlayer;
	}
	
	public Expertise getExpertise() {
		return expertise;
	}
	
	public void setExpertise(String expertise) {
		this.expertise = Expertise.valueOf(expertise);
	}
	
	// Overrided methods
	
	@Override
	public String toString() {
		String out = super.toString() + "Was player: " + wasPlayer + "\n" +
		"Expertise: " + expertise + "\n" + 
		"-----------------------------------\n";
		
		return out;
	}
}
