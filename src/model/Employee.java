package model;

public abstract class Employee {
	
	// -------- Atributes and relations -------- //
	
	private String name;
	private String id;
	private double salary;
	private State state;
	// -------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	public Employee(String name, String id, double salary, String state) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.state = State.valueOf(state);
	}
	
	// ----------------------------------------------------------
	
	// --------------------- Getters and setters -------------------------- //
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = State.valueOf(state);
	}
	
	// --------------------- Methods -------------------------------------- //
	
	/**
	*
	*
	*
	*
	*/
	
	@Override
	public String toString() {
		String out = "\n-----------------------------------\n" +
		"Name: " + name + "\n" +
		"Id: " + id + "\n" +
		"Salary:" + salary + "\n" +
		"State: " + state + "\n";
		
		return out;
	}
}