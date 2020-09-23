public class NQueens {
	public static boolean isStringUnique(String x) {
		//if the string is over 26 characters long then there have to exist duplicate characters
		if(x.length() > 26)
			return false;
		
		boolean[] visited_table = new boolean[128];
		
		for(int i = 0; i < x.length(); i++) {
			int char_val = x.charAt(i);
			if(visited_table[char_val])
				return false; //if already seen return false -> not a unique string
			visited_table[char_val] = true; // store when seen once
		}
		
		return true; // since false flag never return, the string has all unique ascii characters
	}
	
	public static void main(String[] args) {
		//check if a string has all unique characters
		//assume the string is an ASCII string of 2^7 bits = 128
		//create a boolean array to store true if we have seen that particular character already
		
		String x = "iamcool";
		
		boolean result = isStringUnique(x);
		
		System.out.println("is the string " + x + " unique: " + result);
	}
}
