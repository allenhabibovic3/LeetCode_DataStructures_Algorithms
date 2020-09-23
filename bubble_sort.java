//stable in place sorting algo O(n^2)

public class NQueens {
	public static void bubbleSort(int[] A) {
		int n = A.length;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1-i; j++) {
				if(A[j] > A[j+1]) {
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = {-2, 4, 1, 0, 10, 8, 45, 49};
		
		System.out.println("Unsorted List: ");
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		
		bubbleSort(A);
		System.out.println("Sorted list: ");
		
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
