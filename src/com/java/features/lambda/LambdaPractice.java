package com.java.features.lambda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaPractice {

//	WHAT IS A FUNCTIONAL INTERFACE?//
//			A functional interface is an interface that has exactly one abstract method and is meant to represent a single behavior, which can be implemented using a lambda expression.
//	A functional interface must have only one abstract method because a lambda expression has no method name.
//		With exactly one abstract method, the compiler can unambiguously determine which method the lambda implements.

//MEMORIZE	A functional interface has exactly one abstract method so that a lambda expression can be mapped unambiguously to a single behavior. This enables type inference and makes lambdas possible in Java.
//	
//	Default & static methods do NOT count
//
//	This is an interview trap.
//
//	@FunctionalInterface
//	interface Test {
//	    void run();              // abstract
//	    default void log() {}    // OK
//	    static void help() {}    // OK
//	}

	public static void main(String[] args) {
		Employee employee = new Employee();

//		1.	Write a lambda to sort a list of employees by salary descending.
		List<Employee> emp = employee.getEmployees();
		emp.sort(Comparator.comparing((Employee n) -> Integer.parseInt(n.getSalary())).reversed());
		System.out.println(" 1  " + emp);

//		2. Convert anonymous class to lambda. 3. Write a custom functional interface and use it with lambda.  
		Ab abAnoym = new Ab() {
			@Override
			public String ab() {
				return "Abc Anonym";
			}
		};
		Ab abLamda = () -> "Abc Lamda";
		System.out.println(abAnoym.ab());
		System.out.println(abLamda.ab());

//		4. Pass lambda as method parameter. 
		System.out.println("Q4  :  " + LambdaPractice.sumResults(2, 4, (i, j) -> i + j));

//		5. Write lambda that throws an exception. 
		ThrowError err = (i, j) -> {
			if (j == 0)
				throw new IOException();
			return i;
		};
		try {
			System.out.println("Q5.  j!=0  " + err.res(4, 1));
			System.out.println("Q5.  j=0  " + err.res(4, 0));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Q5.  j=0  inside catch");
			e1.printStackTrace();
		}
//		✅ “Effectively final” = A local variable that is not declared final but is never reassigned after initialization.
//		“A variable is effectively final if its reference is assigned only once.
//			Java allows capture in lambdas without the final keyword, but any reassignment makes the code illegal. State mutation is allowed; reference mutation is not.”
//		---------------------------
		// ✔ Valid capture
		String prefix = "EMP-";
		emp.forEach(e1 -> {
			System.out.println(prefix + e1.getName()); // ✔
		}); // prefix never changed.
//		-----------------------------------------------
//		❌ Invalid
//		String prefix2 = "EMP-";
//		emp.forEach(e2 -> {
//		    System.out.println(prefix2 + e2.getName());   // ❌ error in this line prefix2 : Local variable prefix2 defined in an enclosing scope must be final or effectively final
//		});
//		prefix2 = "USR-";   // reassigned What is STILL allowed //Changing object STATE ≠ reassignment.
//		------------------------
		StringBuilder sb = new StringBuilder("hi");
		Runnable r = () -> sb.append(" bro"); // ✔ sb reference not reassigned → effectively final ✔ Mutable content // changed → Java doesn’t care

//		Can lambda access instance variables? 
//		“Lambda can access instance and static variables without restrictions because lambda captures the enclosing object via this. Only local variables must be final or effectively final.”
		LambdaPractice lp = new LambdaPractice();
		lp.run();
		lp.setInstanceVariable("instanceVariableNew");
	}

	private String instanceVariable = "instanceVariable";
	private static String static_variable = "static_variable";

	public void setInstanceVariable(String instanceVariable) {
		this.instanceVariable = instanceVariable;
	}

	public void run() {
		Runnable r = () -> {
			System.out.println(instanceVariable); // ✔ allowed
			System.out.println(static_variable); // ✔ allowed
		};
		r.run();
	}

	private static int sumResults(int a, int b, Sum sum) {
		return sum.res(a, b);
	}
}

@FunctionalInterface
interface ThrowError {
	public int res(int m, int n) throws IOException;
}

@FunctionalInterface
interface Sum {
	public int res(int m, int n);
}

@FunctionalInterface
interface NoThrow {
	void test(Object o);
}

@FunctionalInterface
interface Ab {
	public String ab();
}
