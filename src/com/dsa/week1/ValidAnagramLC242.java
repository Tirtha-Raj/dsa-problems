package com.dsa.week1;

public class ValidAnagramLC242 {
	public static void main(String[] args) {
		System.out.println(isAnagram("nagaram","anagram"));
	}

	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;

        int[] sCount = new int[26];
        int[] tCount = new int[26];
        
        for(char sCh : s.toCharArray()){
            sCount[sCh - 'a']++;
        }
        for(char tCh : t.toCharArray()){
            tCount[tCh - 'a']++;
        }

        for(int i=0;i<sCount.length;i++){
            if(sCount[i] != tCount[i]) return false;

        }
        return true;
	}
}
