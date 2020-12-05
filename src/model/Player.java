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
	*
	*
	*
	*
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
	*
	*
	*
	*
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
	*
	*
	*
	*
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
	*
	*
	*
	*
	*/
	
	@Override // I need to add to the toString methods the MarketPrice and the Stars
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