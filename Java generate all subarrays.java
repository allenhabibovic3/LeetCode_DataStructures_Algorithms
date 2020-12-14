public class NQueens {
	
  
  //O(n^3) time complexity => 3 nested for loops
	public static void allSubArrays(int[] a) {
		int n = a.length;
		
		for(int start = 0; start < n; start++) {
			for(int size = start; size <= n; size++) {
				for(int j = start; j < size; j++) {
					System.out.print(a[j] + " ");
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4};
		
		allSubArrays(a);
	}
}
