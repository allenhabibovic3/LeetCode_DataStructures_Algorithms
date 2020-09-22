public class NQueens {
//maximum number of iterations for binary search of array size n is floor(log_2 N) + 1
	public static int binarySearchIterative(int[] a, int key) {
		int low = 0, high = a.length - 1;
		//two pointers one at beginninng and one at end and adjust accordingly depending on comparison with key and mid element
		//once high pointer passes low, we can conclude that key is not with in array and return -1
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(a[mid] == key)
				return mid;
			else if(key < a[mid])
				high = mid - 1; //search in left half from now on
			else
				low = mid + 1; // search in right half from now on;
		}
		
		return -1;// return if not found.
	}
	
	public static int binarySearchRecursive(int[] a, int key, int low, int high) {
		if(high < low)
			return -1; //base case if the high pointer crosses the low pointer. 
		else {
			int mid = low + (high - low) / 2;
			if(a[mid] == key)
				return mid;
			else if(key < a[mid])
				return binarySearchRecursive(a, key, low, mid - 1);
			else
				return binarySearchRecursive(a, key, mid + 1, high);
		}
	}
	
	public static void main(String[] args) {
		//binary search iterative
		//array has to be sorted
		//O(log_n)
		//cut the searching window by half each pass
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int key = 9;
		
		int index = binarySearchIterative(a, key);
		
		System.out.println("Key of (" + key + ") is at the index: " + index);
		
		int index2 = binarySearchRecursive(a, key, 0, a.length - 1);
		
		System.out.println("recursive binary search result: " + index2);
	}
}
