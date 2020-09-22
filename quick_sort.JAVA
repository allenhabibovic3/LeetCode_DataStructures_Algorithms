//quick sort is divide and conquer algo of O(n lg n)
//picks a pivot element such that all elements to the left of pivot are lesser, and to the right are greater than pivot
//in place sorting algorithm
//worst case is if arrays are already sorted, can be avoided by randomly picking the pivot point
//W(n) = O(n^2)

public class NQueens {
	//utility function to print an array
	public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	//main partition logic which sorts based on picked pivot
	public static int partition(int[] a, int low, int high) {
		//pick last element as pivot and position accordingly
		int pivot = a[high];
		int i = (low - 1);
		
		for(int j = low; j < high; j++) {
			if(a[j] < pivot) {
				i++;
				//swap a[i] and a[j]
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		//swap a[i+1] with a[high]
		int temp = a[i+1];
		a[i+1] = a[high];
		a[high] = temp;
		
		//return pivot
		return (i + 1);
	}
	
	public static void quickSort(int[] a, int low, int high) {
		if(low < high) {
			//returns the pivot index initially pass entire array
			//divide until reached a single element array
			int pi = partition(a, low, high);
			
			//recur on left half excluding pivot and right half excluding pivot
			quickSort(a, low, pi - 1);
			quickSort(a, pi + 1, high);
		}
	}
	
	
	
	public static void main(String[] args) {
		//unsorted 1D Array
		int[] a = {10, 3, 9, 4, 1, 0, -3, 11, 14, 23, 44, 50, 30, 20, 25};
		int low = 0, high = a.length - 1;
		
		System.out.println("Unsorted array: ");
		printArray(a);
		
		quickSort(a, low, high);
		
		System.out.println("\nSorted array: ");
		printArray(a);
	}
}
