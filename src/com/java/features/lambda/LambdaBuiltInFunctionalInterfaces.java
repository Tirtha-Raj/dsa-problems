package com.java.features.lambda;

import java.security.SecureRandom;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaBuiltInFunctionalInterfaces {

	public static void main(String[] args) {
		
//		1. Use Predicate to filter employees with salary > 50k.
		Employee emp = new Employee();
		List<Employee> emps = emp.getEmployees();
		Predicate<Employee> p =n -> Integer.parseInt(n.getSalary()) > 50000;
		List<Employee> richEmps = emps.stream()
				.filter(p)
				.collect(Collectors.toList());
		System.out.println("1. Use Predicate  :  "+richEmps);
		
//		2. Use Function to convert Employee → String. 
		Function<Employee, String> fullEmpInString = (n) -> n.toString();
		List<String> listEmpInString = emps.stream()
				.map(fullEmpInString)
				.toList();
		System.out.println("2. Use Function   :  "+listEmpInString);
//		Diff between .toList(); and .collect(Collectors.toList());
//		“.toList() is terminal shortcut introduced in Java 16 returning unmodifiable list, 	listEmpInString.add("any"); //error runtime Exception in thread "main" java.lang.UnsupportedOperationException
//		while collect(Collectors.toList()) uses collector framework and produces mutable list—usually ArrayList.” richEmps.add possible
//		Use .toList() when:		You just need result snapshot		No modification later		modern codebase
//		Use collect() when:		You MUST mutate		custom collector logic		grouping, mapping collectors
		
//		3. Use Consumer to print employee details.
		Consumer<Employee> consumerEmps = (e) -> System.out.println("3. Use Consumer   :  "+e);
		Consumer<Employee> consumerEmp = System.out::println;
		emps.stream().forEach(consumerEmps);
		emps.stream().forEach(consumerEmp);
		
//		4. Use Supplier to generate random OTP. 
		Supplier<Integer> supplierRandomOTP = () -> new SecureRandom().nextInt(900000)+100000;
		System.out.println("4. Use Supplier   :  "+supplierRandomOTP.get());
		
//		5. Chain predicates using and() / or(). 
		Predicate<Employee> p2 = ((Predicate<Employee>)n -> Integer.parseInt(n.getSalary()) >= 50000).and(a -> a.getName().startsWith("S"));
		System.out.println("5. Chain predicates   :  "+emps.stream().filter(p2).toList());
		
//		Predicate<T>	Purpose	👉 Takes input, returns boolean	Use case Filtering Condition checks Stream .filter()
//		Function<T,R>   Purpose	👉 Takes input T, returns output R	Use case	Transformation	DTO mapping	Stream .map()
//		Consumer<T>  	Purpose	👉 Takes input, returns nothing (void)	Use case Printing Side effects Stream .forEach()
//		Supplier<R> 	Purpose	👉 Takes no input, returns R 	Use case	Object creation	Lazy value supply	Defaults
//		list.stream().
//				filter(predicate)
//				.map(function)
//				.forEach(consumer);     optional.orElseGet(() -> defaultValue);
		
		
	}
}
