package com.learning;

public class Employee {
	
	private long Id;
	
	private String name;
	
	public Employee() {
		
	}
	
	public Employee(long id, String name) {
		this.Id = id;
		this.name = name;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + "]";
	}
	
	

}
