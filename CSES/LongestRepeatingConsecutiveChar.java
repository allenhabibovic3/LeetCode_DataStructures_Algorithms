public class NQueens {
	public static void main(String[] args) {
		String s = "ATTTTCGGGA";
		
		int max = 1;
		int currCount = 0;
		
		for(int i = 0; i < s.length() - 1; i++) {
			for(int j = i+1; j < s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) {
					currCount++;
					
					if(currCount > max) {
						max = currCount;
					}
				}
			}
			currCount = 1;
		}

		System.out.println(max);
	}
}
