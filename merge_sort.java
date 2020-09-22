//MERGE SORT
//Averege case running time is Theta(n lg n)
//Divide and conquer approach
//Creates auxillary arrays of left half/right half
//Not an inplace sorting algo

public class NQueens {
	//utility function to print an array
	public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void merge(int[] a, int low, int mid, int high) {
		int L1 = mid - low + 1;
		int L2 = high - mid;
		
		int[] L = new int[L1];
		int[] R = new int[L2];
		
		for(int i = 0; i < L1; i++) {
			L[i] = a[low + i];
		}
		
		for(int j = 0; j < L2; j++) {
			R[j] = a[mid+1+j];
		}
		
		int i = 0, j = 0, k = low;
		
		while(i < L1 && j < L2) {
			if(L[i] <= R[j])
				a[k++] = L[i++];
			else
				a[k++] = R[j++];
		}
		
		//any remaining elements from either left half or right half just copy over elements back to a.
		while(i < L1)
			a[k++] = L[i++];
		
		while(j < L2)
			a[k++] = R[j++];
	}
	
	public static void mergeSort(int[] a, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			//divide stage until base case(array of single element)
			mergeSort(a, low, mid);
			mergeSort(a, mid+1, high);
			//merge two sorted arrays into a single array *linear time
			merge(a, low, mid, high);
		}
	}
	
	public static void main(String[] args) {
		//unsorted 1D Array
		int[] a = {10, 3, 9, 4, 1, 0, -3, 11, 14, 23, 44, 50, 30, 20, 25};
		int low = 0, high = a.length - 1;
		
		System.out.println("Unsorted array: ");
		printArray(a);
		
		mergeSort(a, low, high);
		
		System.out.println("\nSorted array: ");
		printArray(a);
	}
}
