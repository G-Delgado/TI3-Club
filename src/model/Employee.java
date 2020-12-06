package model;

public abstract class Employee {
	
	// -------- Atributes and relations -------- //
	
	private String name; // Represents the name of the employee
	private String id; // Represents the id of the employee
	private double salary; // Represents the salary of the employee
	private State state; // Represents the state of the employee, from active to inactive
	// -------------------------------------------
	
	// --------------------- Constructor --------------------- //
	
	/**
	* Employee's constructor.
	* pre: All the parameters must be defined.<br>
	* pos: The values of the corresponding atributes are now the ones passed by the parameters.<br>
	* @param name. Represents the name of the employee. <br>
	* @param id. Represents the id of the employee. <br>
	* @param salary. Represents the salary of the employee. <br>
	* @param state. Represents the state of the employee.
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
	* Returns a String with the information of the employee. <br>
	* pre: <br>
	* pos: <br>
	* @return out. A string that contains the atributes and information of the employee.
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