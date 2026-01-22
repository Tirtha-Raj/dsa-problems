package com.java.features.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StremPractice {

	public static void main(String[] args) {

//		1. Filter even numbers from list. 
		List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		List<Integer> evenNum = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("1. Filter even numbers  :  " + evenNum);

//		2. Convert list of strings to uppercase. 
		Employee emp = new Employee();
		List<Employee> emps = emp.getEmployees();
		List<String> namesCaps = emps.stream().map(n -> n.getName().toUpperCase()).toList();
		System.out.println("2. Uppercase Stirng :  " + namesCaps);

//		3. Count elements greater than a value.
		numbers = numbers.stream().filter(n -> n > 5).collect(Collectors.toList());
		System.out.println("3. Count elements greater :  " + numbers);

//		4. Find first matching element.
		Stream<String> namesS = namesCaps.stream().filter(n -> n.startsWith("S"));
		namesCaps = namesS.toList();
		System.out.println("4. First matching element. :  " + namesCaps);

//		Difference between Collection and Stream? 
//			Collection is a data structure that stores elements, 
//				while Stream is a processing abstraction that performs lazy, functional-style operations on a data source. 
//				Stream doesn’t store data, can be consumed once, and executes only at terminal operations.

//		Intermediate vs terminal operations? 
//			Intermediate operations are lazy and return a stream, building the pipeline. Intermediate operations return a Stream and do nothing until a terminal operation is applied. Stream<T>
//				Intermediate:	Example : filter() map() flatMap() sorted() distinct() limit() peek() 
//			Terminal operations trigger execution, produce a result or side effect, and consume the stream.  Example : forEach() collect() toList() reduce() findFirst() anyMatch() count()

//		Why streams are lazy? 
//		Streams are lazy by design
//		Loops are eager by default  Streams are lazy because operations are executed only when a terminal operation is invoked and only on as many elements as needed.
//		Terminal operation example : forEach() collect() toList() reduce() findFirst() anyMatch() count()
	}
}
