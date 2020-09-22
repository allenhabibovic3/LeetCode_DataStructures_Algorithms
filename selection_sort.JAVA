public class NQueens {
	//utility function to print an array
	public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	
	//O(n^2) running time
	//iteratively picks the smallest element and swaps indices
	public static void selectionSort(int[] a) {
		int n = a.length;
		
		for(int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for(int j = i + 1; j < n; j++) {
				if(a[j] < a[min_idx])
					min_idx = j;
			}
			//swap a[i] and a[min_idx]
			int temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}
	}
	
	public static void main(String[] args) {
		//unsorted 1D Array
		int[] a = {10, 3, 9, 4, 1, 0, -3, 11, 14, 23, 44, 50, 30, 20, 25};
		int low = 0, high = a.length - 1;
		
		System.out.println("Unsorted array: ");
		printArray(a);
		
		selectionSort(a);
		
		System.out.println("\nSorted array: ");
		printArray(a);
	}
}
