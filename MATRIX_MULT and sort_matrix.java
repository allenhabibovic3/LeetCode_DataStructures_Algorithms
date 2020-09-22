public class NQueens {
	public static void printResult(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] matrixMult(int[][] A, int[][] B) {
		//matrix multiplication is not commutative AB != BA
		//the number of columns in A has to equal the number of rows in B
		//result has a size of [# of rows in A][# of cols in B]
		
		int[][] C = new int[A.length][B[0].length];
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < B[i].length; j++) {
				C[i][j] = 0;
				for(int k = 0; k < B[i].length; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return C;
	}
	
	public static void sortMatrix(int[][] A) {
		//create a new 1D array so we can copy all the elements from the matrix and just apply a sort on them
		int[] temp = new int[A.length * A.length];
		int k = 0; 
		
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i].length; j++) {
				temp[k++] = A[i][j];
			}
		}
		
		java.util.Arrays.sort(temp);
		
		
		//reset the pointer for the 1D array
		k = 0;
		//copy the sorted elements from temp 1D array to matrix one by one
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i].length; j++)
				A[i][j] = temp[k++];
		}
	}
	
	public static void main(String[] args) {
		int[][] A = {{2,3,4}, {4,3,2}, {4, 5, 6}};
		int[][] B = {{4,3,2}, {4, 5, 6}, {10,11,12}};
		
		int[][] C = matrixMult(A, B);
		
		printResult(C);
		
		System.out.println("***********************************************");
		
		System.out.println("Unsorted matrix: ");
		printResult(A);
		
		sortMatrix(A);
		System.out.println("Sorted matrix: ");
		printResult(A);
	}
}
