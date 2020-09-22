public class NQueens {
	public static void zeroMatrix(int[][] matrix) {
		//keep track of where the zero appears
		//create two boolean arrays, one for the row and one for col since more than 1 zero can occur in matrix
		boolean[] zeroRow = new boolean[matrix.length];
		boolean[] zeroCol = new boolean[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					zeroRow[i] = true;
					zeroCol[j] = true;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			if(zeroRow[i])
				nullRow(matrix, i);
		}
		
		for(int j = 0; j < matrix[0].length; j++) {
			if(zeroCol[j])
				nullCol(matrix, j);
		}
	}
	
	public static void nullRow(int[][] matrix, int row) {
		for(int i = 0; i < matrix[0].length; i++)
			matrix[row][i] = 0;
	}
	
	public static void nullCol(int[][] matrix, int col) {
		for(int j = 0; j < matrix.length; j++) {
			matrix[j][col] = 0;
		}
	}
	
	public static void main(String[] args) {
		//zero out the row and col wherever a 0 appears in a matrix
		
		int[][] test_matrix = {{1, 0, 1}, {1, 1, 1}, {1, 1, 1}};
		
		zeroMatrix(test_matrix);
		
		for(int i = 0; i < test_matrix.length; i++) {
			for(int j = 0; j < test_matrix[i].length; j++) {
				System.out.print(test_matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
