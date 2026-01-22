package com.java.features.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {
	private String name;
	private String salary;
	private String dept;
	private int empId;

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

	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public Employee(String name, String salary, String dept, int empId) {
		super();
		this.name = name;
		this.salary = salary;
		this.dept = dept;
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", dept=" + dept + ", empId=" + empId + "]";
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
	
	public List<Employee> getEmployeesDetails() {

	    Employee a = new Employee("Soham", "70000", "Java", 2525255);
	    Employee b = new Employee("Tirtha", "60000", "Java", 2525256);
	    Employee c = new Employee("Smriti", "80000", "Java", 2525257);
	    Employee d = new Employee("Koushik", "68000", "Java", 2525258);
	    Employee e = new Employee("Souvik", "70000", "Java", 2525259);
	    Employee f = new Employee("Sagnik", "90000", "BA", 1111111);
	    Employee g = new Employee("Ananya", "75000", "Python", 1111112);
	    Employee h = new Employee("Rohit", "70000", "QA", 1111113);
	    Employee i = new Employee("Priya", "68000", "Support", 1111114);
	    Employee j = new Employee("Arjun", "85000", "Support", 1111115);
	    Employee k = new Employee("Neha", "70000", "Java", 1111116);
	    Employee l = new Employee("Amit", "50000", "Support", 1111117);
	    Employee m = new Employee("Pallavi", "70000", "Python", 1111118);
	    Employee n = new Employee("Rahul", "92000", "Support", 1111119);
	    Employee o = new Employee("Sneha", "68000", "QA", 1111120);

	    List<Employee> emp = new ArrayList<>(Arrays.asList(
	            a, b, c, d, e, f,
	            g, h, i, j, k, l,
	            m, n, o
	    ));

	    return emp;
	}

}
