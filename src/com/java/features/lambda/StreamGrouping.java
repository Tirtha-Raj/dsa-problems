package com.java.features.lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGrouping {

	public static void main(String[] args) {

		Employee emp = new Employee();
		List<Employee> empDetails = emp.getEmployeesDetails();
		
//		1. Group employees by department
		Map<String, List<Employee>> groupEmps = empDetails.stream()
															.collect(Collectors.groupingBy(Employee::getDept));// instead e -> e.getDept()
		System.out.println("1. Group employees  :  "+groupEmps);
		
//		2. Group and count employees per department
		Map<String, Long> groupCount = empDetails.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
		System.out.println("2. Group and count  :  "+groupCount);
		
//		3. Group employees by department and average salary. 
		Map<String, Double> groupDeptAvgSalary = empDetails.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingInt(n-> Integer.parseInt(n.getSalary()))));
		System.out.println("3. Group employees by avg salary  :  "+groupDeptAvgSalary);
		
//		4. Partition numbers into even and odd. 
		Map<String,List<Employee>> evenOdd= empDetails.stream().collect(Collectors.groupingBy(n -> n.getEmpId()%2 ==0 ?"Even":"Odd"));
		System.out.println("4. Partition numbers  :  "+evenOdd);
		Map<Boolean,List<Integer>> mapPartition = empDetails.stream().map(e -> e.getEmpId()).collect(Collectors.partitioningBy(n -> n%2 ==0));
		Map<Boolean,List<Integer>> mapGroup= empDetails.stream().map(e -> e.getEmpId()).collect(Collectors.groupingBy(n -> n%2 ==0));
		System.out.println("4.a Partition numbers  :  "+mapPartition);
		System.out.println("4.b Partition numbers uaing groupingBy  :  "+mapGroup);
		
//		5. Group strings by length.
		Map<Integer, List<String>> groupByLength = empDetails.stream().map(n->n.getName()).collect(Collectors.groupingBy(n -> n.length()));
		System.out.println("5. Group strings by length  :  "+groupByLength);
	}
}
