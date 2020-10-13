public class NQueens {
	
	public static int longestConsecutive(String x) {
		StringBuilder sb = new StringBuilder();
		int countLength = 0;
		int max = 0;
		for(int i = 0; i < x.length(); i++) {
			countLength++;
			
			if(i + 1 >= x.length() || x.charAt(i) != x.charAt(i+1)) {
				countLength = 1;
			}
			if(max < countLength)
				max = countLength;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		String x = "AABCCCDDEEEE";
		
		int longest = longestConsecutive(x);
		
		System.out.println("Longest =  " + longest);
	}
}
