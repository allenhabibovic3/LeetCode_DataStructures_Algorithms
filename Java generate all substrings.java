public class NQueens {
	
	public static void allSubstrings(String s, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j <= n; j++) {
				System.out.println(s.substring(i, j));
			}
		}
	}
	
	public static void main(String[] args) {
		
		String s = "abcd";
		int n = s.length();
		
		allSubstrings(s, n);
	}
}
