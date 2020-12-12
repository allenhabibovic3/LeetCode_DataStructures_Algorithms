public class NQueens {
	//rotate any nxn matrix
	//first find the transpose of input matrix a[i][j] = aT[j][i];
	//find mirror of transpose matrix
	public static int[][] rotateMatrix(int[][] a) {
		//assume we get a valid nxn matrix as input
		int n = a.length;
		int[][] r = new int[n][n];
		int[][] transpose = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				transpose[i][j] = a[j][i];
			}
		}
		
		//step 2
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < (n/2); j++) {
				int temp = transpose[i][j];
				transpose[i][j] = transpose[i][n-1-j];
				transpose[i][n-1-j] = temp;
			}
		}
		
		return transpose;
	}
	
	public static void main(String[] args) {
		
		int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] aT = rotateMatrix(A);
		
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A.length; j++) {
				System.out.print(aT[i][j] + " ");
			}
			System.out.println();
		}
	}
}
