public class NQueens {
	
	//minimum number of edits(change letter, delete letter)
	//to convert string a to b
	
	//dynamic programming(bottom-up)
	//if letters are mismatch M[i, j] = min(M[i-1][j], M[i][j-1], M[i-1][j-1]) + 1
	//if letters are a match M[i, j] = M[i-1][j-1]
	
	//M[i, j] = [len(s1) + 1][len(s2) + 1]
	//solution is at M[len(s1)][len(s2)]
	public static int minEditDistance(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		
		int[][] M = new int[m+1][n+1];
		
		//fill row 0, and col 0
		for(int j = 0; j < M.length; j++)
			M[j][0] = j;
		
		for(int i = 0; i < M[0].length; i++) {
			M[0][i] = i;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s1.charAt(i-1) != s2.charAt(j-1))
					M[i][j] = Math.min(Math.min(M[i-1][j], M[i][j-1]), M[i-1][j-1]) + 1;
				else
					M[i][j] = M[i-1][j-1];
			}
		}
		
		printEdits(M, s1, s2);
		return M[m][n];
	}
	
	public static void printEdits(int[][] M, String s1, String s2) {
		
		//i -> string1
		//j -> string2
		
		int i = M.length - 1;
		int j = M[0].length - 1;
		
		while(i > 0 && j > 0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				i--;
				j--;
			}else if(M[i][j] == M[i-1][j-1] + 1) {
				System.out.println("Edit " + s2.charAt(j-1) + " in string 2 to " + s1.charAt(i-1) + " in string 1.");
				i--;
				j--;
			}else if(M[i][j] == M[i-1][j] + 1) {
				System.out.println("Delete " + s1.charAt(i-1) + " in string 1");
				i--;
			}else if(M[i][j] == M[i][j-1] + 1) {
				System.out.println("Delete " + s2.charAt(j-1) + " in string 2.");
				j--;
			}
		}
	}
	
	public static void main(String[] args) {
		
		String s1 = "abcdef";
		String s2 = "azced";
		
		int min = minEditDistance(s1, s2);
		
		System.out.println("Minimum # of edits => " + min);
	}
}
