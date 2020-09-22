public class NQueens {
	public static String compressString(String s) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		//create a stringbuilder to construct the new compressed string
		//keep track of the consecutive counts by checking adjacent characters in string
		
		for(int i = 0; i < s.length(); i++) {
			countConsecutive++;//see one character so increment by 1
			if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
				//if the adjacent characters dont match, append to string the current character and the count
				if(countConsecutive == 1) {
					compressed.append(s.charAt(i));
				}else {
					compressed.append(s.charAt(i));
					compressed.append(countConsecutive);
				}
				countConsecutive = 0;
			}
		}
		
		return (compressed.length() < s.length()) ? compressed.toString() : s;
	}
	
	public static void main(String[] args) {
		//simple string compression
		//aabbbcceeee = a2b3c2e4
		
		String uncompressed_string = "abbbcceeee";
		String compressed_string = compressString(uncompressed_string);
		
		System.out.println("The compressed string is: " + compressed_string);
	}
}
