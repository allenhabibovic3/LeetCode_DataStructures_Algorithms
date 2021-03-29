package chapter07;

import java.util.Arrays;
import java.util.HashMap;

public class Graph {
	
	public static char mostCommonChar(String s) {
		
		HashMap<Character, Integer> char_counts = new HashMap<Character, Integer>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(char_counts.get(c) != null) {
				char_counts.put(c, char_counts.get(c) + 1);
			}else {
				char_counts.put(c, 1);
			}
		}
		
		int max = 1;
		char ch = '-';
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(char_counts.get(c) > max) {
				max = char_counts.get(c);
				ch = c;
			}
		}
		
		return ch;
	}
	
	public static void main(String[] args) {
		String S = "aabcaaaabbbcdddedbababaabcaaaad";
		
		char result = mostCommonChar(S);
		System.out.println(result);
	}
}
