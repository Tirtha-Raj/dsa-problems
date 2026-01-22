package com.java.features.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MediumLevel {
	public static void main(String[] args) {
		Employee emp = new Employee();
		List<Employee> empDetails = emp.getEmployeesDetails();
		List<String> numbers = empDetails.stream().map(Employee::getSalary).collect(Collectors.toList());
		
//		1. Remove duplicates from list of integers
		List<String> removedDuplicates = numbers.stream().distinct().toList();
		Set<String> set = new HashSet<>();
		List<String> withoutDuplicates = numbers.stream().filter(n -> set.add(n)).toList();
		System.out.println("1.a Remove duplicates  : "+removedDuplicates);
		System.out.println("1.b Remove duplicates  : "+withoutDuplicates);
	}

}
