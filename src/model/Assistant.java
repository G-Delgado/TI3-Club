package model;

public class Assistant extends Coach {
	
	// --------------------- Atributes and relations --------------------- //
	
	private boolean wasPlayer; // Represents whether the assitant has been a player in the past.
	private Expertise expertise; // Represents the field of expertise of the assistant. (Offensive, Defensive, Controller, etc.)
	// ----------------------------------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	/**
	* Assistant's constructor.
	* pre:  All the parameters must be defined. <br>
	* pos: The values of the corresponding atributes are now the ones passed by the parameters.<br>
	* @param name. Represents the name of the assistant. <br>
	* @param id. Represents the id of the assistant. <br>
	* @param salary. Represents the salary of the assistant. <br>
	* @param state. Represents the state of the assistant. <br>
	* @param yearsOfExperience. Represents the years of experience of the assistant. <br>
	* @param wasPlayer. Represents whether the assistant is a former player. <br>
	* @param expertise. Represents the expertise of the assistant.
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
	* Returns a String with all the information of the assistant. <br>
	* pre: <br>
	* pos: <br>
	* @return out. A string that contains all the information of the assistant.
	*/
	
	@Override
	public String toString() {
		String out = super.toString() + "Was player: " + wasPlayer + "\n" +
		"Expertise: " + expertise + "\n" + 
		"-----------------------------------\n";
		
		return out;
	}
}
