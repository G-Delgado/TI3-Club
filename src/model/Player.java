package model;

public class Player extends Employee implements Profitable {
	
	// --------------------- Atributes and relations --------------------- //
	
	private int shirtNumber; // Represents the number of the shirt of the player
	private int numberOfGoals; // Represents the number of goals the player has made so far.
	private double averageRating; // Represents the average rating of the player
	private Position position; // Represents the position of the player (Stricker, Midfield, etc.)
	// ----------------------------------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	/**
	* Player's constructor.
	* pre: All the parameters must be defined. <br>
	* pos: The values of the corresponding atributes are now the ones passed by the parameters.<br>
	* @param name. Represents the name of the player. <br>
	* @param id. Represents the id of the player. <br>
	* @param salary. Represents the salary of the player. <br>
	* @param state. Represents the state of the player. <br>
	* @param shirtNumber. Represents the shirt number of the player. <br>
	* @param numberOfGoals. Represents the number of goals made so far by the player. <br>
	* @param averageRating. Represents the actual average rating of the player. <br>
	* @param position. Represents the position of the player.
	*/
	
	public Player (String name, String id, double salary, String state, int shirtNumber, int numberOfGoals, double averageRating, String position) {
		super(name, id, salary, state);
		this.shirtNumber = shirtNumber;
		this.numberOfGoals = numberOfGoals;
		this.averageRating = averageRating;
		this.position = Position.valueOf(position);
	}
	
	// -----------------------------------------------------------
	
	// --------------------- Getters and setters --------------------- //
	
	public int getShirtNumber() {
		return shirtNumber;
	}
	
	public void setShirtNumber(int shirtNumber) {
		this.shirtNumber = shirtNumber;
	}
	
	public int getNumberOfGoals() {
		return numberOfGoals;
	}
	
	public void setNumberOfGoals(int numberOfGoals) {
		this.numberOfGoals = numberOfGoals;
	}
	
	public double getAverageRating() {
		return averageRating;
	}
	
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = Position.valueOf(position);
	}
	
	// --------------------- Inherited methods from profitable interface --------------------- //
	
	/**
	* Calculates and returns the market price of the player.
	* pre: The position, averageRating, salary and numberOfGoals must be defined.<br>
	* pos: <br>
	* @return marketPrice. A double that represents the market price of the player.
	*/
	
	public double calculateMarketPrice() {
		double marketPrice = 0;
		if (position == Position.GOALKEEPER) {
			marketPrice  = (getSalary() * 12) + (averageRating * 150);
		} else if (position == Position.DEFENDER) {
			marketPrice  = (getSalary() * 13) + (averageRating * 125) + (numberOfGoals * 100);
		} else if (position == Position.MIDFIELD) {
			marketPrice  = (getSalary() * 14) + (averageRating * 135) + (numberOfGoals * 125);
		} else {
			marketPrice  = (getSalary() * 15) + (averageRating * 145) + (numberOfGoals * 150);
		}
		
		return marketPrice;
	}
	
	/**
	* Calculates and returns the star level of the player. 
	* pre: The position, averageRating and numberOfGoals must be defined. <br>
	* pos: <br>
	* @return stars. A double that represents the star level of the player.
	*/
	
	public double calculateStars() {
		double stars = 0;
		if (position == Position.GOALKEEPER) {
			stars = averageRating * 0.9;
		} else if (position == Position.DEFENDER) {
			stars = (averageRating * 0.9) + (numberOfGoals/100);
		} else if (position == Position.MIDFIELD) {
			stars = (averageRating * 0.9) + (numberOfGoals/90);
		} else {
			stars = (averageRating * 0.9) + (numberOfGoals/80);
		}
		
		return stars;
	}
	
	// --------------------- Overrided methods --------------------- //
	
	/**
	* Returns a String with all the information of the player.
	* pre: <br>
	* pos: <br>
	* @return out. A string that contains the player's information.
	*/
	
	@Override
	public String toString() {
		String out = super.toString() + "Shirt number: " + shirtNumber + "\n" +
		"Number of goals: " + numberOfGoals + "\n" +
		"Average rating: " + averageRating + "\n" +
		"Position: " + position + "\n" +
		"Market price: " + calculateMarketPrice() + "\n" +
		"Stars level: " + calculateStars() + "\n" +
		"-----------------------------------\n";
		
		return out;
	}
	
}