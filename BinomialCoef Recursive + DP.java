public class NQueens {
	public static int binomialCoefRecursive(int n, int k) {
		if(k == 0 || n == k)
			return 1;
		//base case if k is 0, we can choose it 1 one way or if n == k then also 1 way
		return binomialCoefRecursive(n-1, k-1) + binomialCoefRecursive(n-1, k);
	}
	
	//utitlity function to return min of two ints
	public static int min(int a, int b) {
		return (a < b) ? a : b;
	}
	
	public static int binomialCoefDP(int n, int k) {
		int[][] C = new int[n+1][k+1];
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= min(i, k); j++) {
				if(i == j || j == 0)
					C[i][j] = 1;
				else
					C[i][j] = C[i-1][j-1] + C[i-1][j];
			}
		}
		return C[n][k];
	}
	
	
	public static void main(String[] args) {
		
		//implement binomial co-ef recursively
		//returns the number of possible selections of k subsets from a set n
		//combinations nCk = n!/(n-k)!k!
		
		int b = binomialCoefRecursive(5, 2);
		
		System.out.println("10 choose 5 = " + b);
		
		int b_dp = binomialCoefDP(10, 5);
		
		System.out.println("10 choose 5 = " + b_dp);
	}
}
