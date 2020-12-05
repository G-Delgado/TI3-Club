package model;

public class Alignment {
	
	// --------------------- Atributes and relations --------------------- //
	
	private String date;
	private int[][] formation;
	private Tactic tactic;
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