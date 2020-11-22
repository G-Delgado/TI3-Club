package model;

public class Player extends Employee implements Profitable {
	private int shirtNumber;
	private int numberOfGoals;
	private double averageRating;
	private Position position;
	
	public Player (String name, String id, double salary, String state, int shirtNumber, int numberOfGoals, double averageRating, String position) {
		super(name, id, salary, state);
		this.shirtNumber = shirtNumber;
		this.numberOfGoals = numberOfGoals;
		this.averageRating = averageRating;
		this.position = Position.valueOf(position);
	}
	
	public double calculateMarketPrice() {
		return 0;
	}
	
	public double calculateStars() {
		return 0;
	}
}