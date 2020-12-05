package model;

public class Assistant extends Coach {
	
	// --------------------- Atributes and relations --------------------- //
	
	private boolean wasPlayer; // Represents whether the assitant has been a player in the past.
	private Expertise expertise; // Represents the field of expertise of the assistant. (Offensive, Defensive, Controller, etc.)
	// ----------------------------------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	public Assistant (String name, String id, double salary, String state, int yearsOfExperience, boolean wasPlayer, String expertise) {
		super(name, id, salary, state, yearsOfExperience);
		this.wasPlayer = wasPlayer;
		this.expertise = Expertise.valueOf(expertise);
	}
	
	// ----------------------------------------------------------
	
	// --------------------- Getters and Setters --------------------- //
	
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
	
	// --------------------- Overrided methods --------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	@Override
	public String toString() {
		String out = super.toString() + "Was player: " + wasPlayer + "\n" +
		"Expertise: " + expertise + "\n" + 
		"-----------------------------------\n";
		
		return out;
	}
}
