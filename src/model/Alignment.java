package model;

public class Alignment {
	
	// --------------------- Atributes and relations --------------------- //
	
	private String date; // Date of (creation/use) of the alignment
	private int[][] formation; // Binary matrix that represents with 0's and 1's the location of players on the field.
	private Tactic tactic; // The tactic of the alignment
	// ----------------------------------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	/**
	* Alignment's constructor. <br>
	* pre: All the parameters must be defined. <br>
	* pos: The values of the corresponding atributes are now the ones passed by the parameters.<br>
	* @param date. Represents the date of (creation/use) of the alignment <br>
	* @param formation. Represents the formation in a binary matrix. <br>
	* @param tactic. Represents the tactic of the alignment.
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
	* Transforms the formation into a String and returns a String with all the information of the alignment. <br>
	* pre: <br>
	* pos: <br>
	* @return out. Represents the information of the alignment. <br>
	*/
	
	@Override
	public String toString() { // I need to fill up this part 
		
		int count = 0;
		String formationString = "";
		String formationInMatrix = "";
		
		for (int i = 0; i < formation.length; i++) {
			count = 0;
			for (int j = 0; j < formation[0].length; j++) {
				formationInMatrix += formation[i][j] + "\t";
				count += formation[i][j];
			}
			if (i == formation.length - 1 && count != 0 || (i == formation.length - 2 && count != 0)) {
				formationString += count;
			} else if (count != 0) {
				formationString += count + "-";
			}	
			formationInMatrix += "\n";
		}
		
		
		
		
		String[] mockArray = formationString.split("-");
		formationString = "";
		
		for (int i = mockArray.length - 1; i >= 0; i--) {
			if (i != 0) {
				formationString += mockArray[i] + "-";
			} else {
				formationString += mockArray[i];
			}
		}
		
		String out = "\n------------\nDate: " + date + "\n" +
		"Formation: " + formationString + "\n" + 
		"--------- Representation in a matrix ---------\n" + formationInMatrix + "\n" +
		"Tactic: " + tactic + "\n" + 
		"------------\n";
		return  out;
	}
	
}