package com.java.features.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {
	private String name;
	private String salary;

	public Employee(String name, String salary) {
		this.name = name;
		this.salary = salary;
	}
	public Employee() {
	}
	public String getName() {
		return this.name;
	}

	public String getSalary() {
		return this.salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";

	}
	
	public List<Employee> getEmployees(){
		Employee a = new Employee("Soham", "70000");
		Employee b = new Employee("Tirtha", "60000");
		Employee c = new Employee("Smriti", "80000");
		Employee d = new Employee("Koushik", "60000");
		Employee e = new Employee("Souvik", "30000");
		Employee f = new Employee("Sagnik", "90000");

		List<Employee> emp = new ArrayList<>(Arrays.asList(a, b, c, d, e, f));
		return emp;
	}
}
