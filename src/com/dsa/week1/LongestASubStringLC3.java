package com.dsa.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestASubStringLC3 {
//	3. Longest Substring Without Repeating Characters
//	Solved
//	Medium
//	Topics
//	premium lock icon
//	Companies
//	Hint
//	Given a string s, find the length of the longest substring without duplicate characters.
//
//	 
//
//	Example 1:
//
//	Input: s = "abcabcbb"
//	Output: 3
//	Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
//	Example 2:
//
//	Input: s = "bbbbb"
//	Output: 1
//	Explanation: The answer is "b", with the length of 1.
//	Example 3:
//
//	Input: s = "pwwkew"
//	Output: 3
//	Explanation: The answer is "wke", with the length of 3.
//	Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringUsingSet("bbbbb"));
		System.out.println(lengthOfLongestSubstringUsingMap("bbbbb"));
	}

	public static int lengthOfLongestSubstringUsingSet(String s) {
		Set<Character> set = new HashSet<>();
		int left = 0, max = 0;
		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			while (set.contains(ch)) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(ch);
			max = Math.max(max, right - left + 1);
		}
		return max;
	}

	public static int lengthOfLongestSubstringUsingMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int left = 0, max = 0;
		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			if(map.containsKey(ch)) {
				left = Math.max(left, map.get(ch) +1);
			}
			map.put(ch, right);
			max = Math.max(max, right-left+1);
		}
		return max;
	}

}
