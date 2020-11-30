public class NQueens {
	
	static int n;
	static int[] col;
	
	public static void solveNQ(int n, int[] col, int i) {
		int j;
		
		if(isPromising(col, i)) {
			if(i == n) {
				for(int k = 1; k <= n; k++)
					System.out.print(col[k] + " ");
				System.out.println();
			}else {
				for(j = 1; j <= n; j++) {
					col[i+1] = j;
					solveNQ(n, col, i+1);
				}
			}
		}
	}
	
	
	public static boolean isPromising(int[] col, int i) {
		int k;
		boolean result;
		
		k = 1;
		result = true;
		
		while(k < i && result) {
			if(col[i] == col[k] || Math.abs((int)(col[i] - col[k])) == i - k) 
				result = false;
			k++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		n = 4;
		col = new int[n+1];
		col[0] = 0;
		
		solveNQ(n, col, 0);
	}
}
