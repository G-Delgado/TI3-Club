package model;

public class Alignment {
	private String date;
	private int[][] formation;
	private Tactic tactic;
	
	public Alignment (String date, int[][] formation, String tactic) {
		this.date = date;
		this.formation = formation;
		this.tactic = Tactic.valueOf(tactic);
	}
}