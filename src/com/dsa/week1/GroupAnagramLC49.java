package com.dsa.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramLC49 {
//	Example 1:
//		Input: strs = ["eat","tea","tan","ate","nat","bat"]
//		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
		
	}
	 public static List<List<String>> groupAnagrams(String[] strs) {
		 Map<String , List<String>> map = new HashMap<>();
		 for(String s : strs) {
			 int[] count = new int[26];
			 for(char ch : s.toCharArray()) {
				 count[ch - 'a']++;
			 }
			 
			 StringBuilder sb = new StringBuilder();
			 for(int num : count) {
				 sb.append(num).append('#');
			 }
			 String key = sb.toString();
			 map.computeIfAbsent(key, n -> new ArrayList<>()).add(s);
		 }
		 
		return new ArrayList<>(map.values());
		 
	 }
}
