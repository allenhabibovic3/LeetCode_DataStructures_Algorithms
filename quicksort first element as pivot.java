public class NQueens {
	
	public static int partition(int[] A, int low, int high) {
		int pivot = A[low];
		int i = low + 1;
		
		for(int j = low + 1; j <= high; j++) {
			
			if(A[j] < pivot) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				
				i++;
			}
		}
		
		int temp = A[low];
		A[low] = A[i-1];
		A[i-1] = temp;
		
		for(int k = 0; k < A.length; k++) {
			System.out.print(A[k] + " ");
		}
		System.out.println();
		
		return (i-1);
	}
	
	public static void quickSort(int[] A, int low, int high) {
		
		if(low < high) {
			
			int pi = partition(A, low, high);
			quickSort(A, low, pi - 1);
			quickSort(A, pi + 1, high);
		}
	}
	
	public static void main(String[] args) {
		
		int[] A = {12, 5, 7, 19, 10, 9, 3, 20, 6, 18};	
		int low = 0, high = A.length - 1;
		
		quickSort(A, low, high);
		
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
