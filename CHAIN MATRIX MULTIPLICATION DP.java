public class NQueens {
	//time complexity is O(n^3) where n = # of matrices being multiplied in the seq.
  //space complexity is O(2n^2) for the two matrix tables one for cost which stores at C[1][n-1] the min # of multiplications
  //and P[][] which tells us how the sequence is parenthesized since matrix multiplication is associative, different ordering
  //of parenthesis results in the same product, however matrix multiplication is not a commutative operation
  //valid matrix multiplication for A * B : # of cols in A = # of rows in B, result matrix dimensions = # Of rows in A X # of cols in B
	public static void printOrder(int[][] P, int i, int j) {
		if(i == j)
			System.out.print("A" + i);
		else {
			int k = P[i][j];
			
			System.out.print("(");
			printOrder(P, i, k);
			printOrder(P, k+1, j);
			
			System.out.print(")");
		}
	}
	
	public static int chainMult(int[] dims) {
		int n = dims.length;
		int[][] C = new int[n+1][n+1];
		int[][] P = new int[n+1][n+1];
		
		for(int len = 2; len <= n; len++) {
			for(int i = 1; i <= n - len + 1; i++) {
				int j = len + i - 1;
				C[i][j] = Integer.MAX_VALUE;
				for(int k = i; j < n && k < j; k++) {
					int cost = C[i][k] + C[k+1][j] + dims[i-1] * dims[k] * dims[j];
					if(cost < C[i][j]) {
						C[i][j] = cost;
						P[i][j] = k;
					}
				}
			}
		}
		
		printOrder(P, 0, n-1);
		
		return C[1][n-1];
	}
	
	public static void main(String[] args) {
		
		int[] dims = {3, 2, 4, 2, 5};
		
		int result = chainMult(dims);
		
		System.out.println("\nRESULT => " + result);
		
		
	}
}
