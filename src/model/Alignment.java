package model;

public class Alignment {
	
	// --------------------- Atributes and relations --------------------- //
	
	private String date; // Date of (creation/use) of the alignment
	private int[][] formation; // Binary matrix that represents with 0's and 1's the location of players on the field.
	private Tactic tactic; // The tactic of the alignment
	// ----------------------------------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	public Alignment (String date, int[][] formation, String tactic) {
		this.date = date;
		this.formation = formation;
		this.tactic = Tactic.valueOf(tactic);
	}
	
	// ----------------------------------------------------------
	
	// --------------------- Getters and Setters --------------------- //
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public int[][] getFormation() {
		return formation;
	}
	
	public void setFormation(int[][] formation) { // We are going to create the matrix in the club zone or team zone.
		this.formation = formation;
	}
	
	public Tactic getTactic() {
		return tactic;
	}
	
	public void setTactic(String tactic) {
		this.tactic = Tactic.valueOf(tactic);
	}
	
	// --------------------- Overrided methods --------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	@Override
	public String toString() { // I need to fill up this part.
		return  "";
	}
	
}