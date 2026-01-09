package com.java.features;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {
public static void main(String[] args) {
	Map<StringBuilder, String> map = new HashMap<>();

	StringBuilder key = new StringBuilder("abc");
	map.put(key, "value");
	key.append("b");
	
	System.out.println(map.get(key));
	System.out.println(map.get(new StringBuilder("abcb")));
	
	StringBuilder a = new StringBuilder("abc");
	StringBuilder b = new StringBuilder("abc");

	System.out.println(a.equals(b)); // false

	
}
}
