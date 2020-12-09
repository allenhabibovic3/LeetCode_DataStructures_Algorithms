public class NQueens {
	//KADANES ALGORITHM dp approach
	//linear running time
	//naive solution: generate all possible subsets, find max -> O(n^2) where n = len(arr)
	//sub array has to be contigous
	public static int maxSumSubArray(int[] a) {
		int maxSum = a[0];
		int currSum = maxSum;
		
		for(int i = 1; i < a.length; i++) {
			currSum = Math.max(a[i] + currSum, a[i]);//add curr element to sum or begin new
			maxSum = Math.max(currSum, maxSum);
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		
		int[] A = {-2, 2, 5, -11, 6};
		int r = maxSumSubArray(A);
		
		System.out.println(r);
	}
}
