public class NQueens {
  //n = len(txt)
  //m = len(pat)
	//time complexity is O(n + m), space complexity O(m) => to build the LPS array(tells us where to start comparisons after mismatch
	public static void patternSearchKMP(String txt, String pat) {
		
		int N = txt.length();
		int M = pat.length();
		
		int[] LPS = new int[M];
		
		//construct the LPS array, strings that have same suffix(ending) as prefix(beginning)
		computeLPS(pat, M, LPS);
		
		int i = 0, j = 0; //i is the index used to search txt, j is the index for pat
		
		while(i < N) {
			
			if(txt.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			if(j == M) {
				System.out.println("Find pat in txt at index: " + (i-j));
				j = LPS[j-1];
			}else if(i < N && pat.charAt(j) != txt.charAt(i)) {
				if(j != 0) {
					j = LPS[j-1];
				}else {
					i++;
				}
			}
		}
	}
	
	public static void computeLPS(String pat, int M, int[] lps) {
		int j = 0;
		int i = 1;
		lps[0] = 0;
		
		while(i < M) {
			if(pat.charAt(i) == pat.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			}else {
				if(j != 0)
					j = lps[j-1];
				else {
					lps[i] = j;
					i++;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		String txt = "AABAACAADAABAABA"; 
        String pat = "AABA"; 
        
        patternSearchKMP(txt, pat);
	}
}
