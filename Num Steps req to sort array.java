public class NQueens {
	
	public static int countInversions(int[] A) {
		int n = A.length;
		
		int r = 0;
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(A[i] > A[j]) {
					r++;
				}
			}
		}
		
		return r;
	}
	
	public static void merge(int[] A, int low, int mid, int high) {
		
		int L1 = mid - low + 1;
		int L2 = high - mid;
		
		int[] L = new int[L1];
		int[] R = new int[L2];
		
		for(int i = 0; i < L1; i++) {
			L[i] = A[low + i];
		}
		
		for(int j = 0; j < L2; j++) {
			R[j] = A[mid + 1 + j];
		}
		
		int i = 0, j = 0, k = low;
		
		while(i < L1 && j < L2) {
			if(L[i] < R[j]) {
				A[k++] = L[i++];
			}else {
				A[k++] = R[j++];
			}
		}
		
		while(i < L1) {
			A[k++] = L[i++];
		}
		
		while (j < L2) {
			A[k++] = R[j++];
		}
	}
	
	public static void mergeSort(int[] A, int low, int high) {
		if(low < high) {
			int mid = low + (high - low) / 2;
			
			mergeSort(A, low, mid);
			mergeSort(A, mid + 1, high);
			
			merge(A, low, mid, high);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {30, 20, 10, 0, 3, 4, 2, 0, -1, -2};
		
		int low = 0, high = A.length - 1;
		
		int inv_count = countInversions(A);
		
		System.out.println("# OF INVERSIONS PRE-SORT: " + inv_count);
		
		mergeSort(A, low, high);
		
		inv_count = countInversions(A);
		
		System.out.println("# OF INVERSIONS POST-SORT: " + inv_count);
	}
}
