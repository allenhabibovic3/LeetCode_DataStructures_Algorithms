//divide and conquer approach

public class NQueens {
	public static boolean evenOccurrences(int[] A, int low, int high, int x) {
		if(low == high)
			return !(A[low] == x); //base condition, if we have one item in our array, and if that equals our 'x' then this occurs 1
									//time and is AN ODD occurence so false
		else {
			int mid = low + (high - low) / 2;
			
			boolean leftHalf = evenOccurrences(A, low, mid, x);
			boolean rightHalf = evenOccurrences(A, mid+1, high, x);
			
			return (leftHalf == rightHalf);
			//odd + odd = even !(0 XOR 0) = 1
			//even + even = even
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3, 3, 4, 9, 3, 0, 1, 2};
		int low = 0;
		int high = A.length - 1;
		
		int x = 3;
		
		boolean result = evenOccurrences(A, low, high, x);
		
		System.out.println(x + " occurs an even # of times? " + result);
	}
}
