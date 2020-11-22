package model;

public abstract class Employee {
	private String name;
	private String id;
	private double salary;
	private State state;
	
	public Employee(String name, String id, double salary, String state) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.state = State.valueOf(state);
	}
}