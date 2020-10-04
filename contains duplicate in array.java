public class NQueens {
	public static boolean containsDuplicate(int[] A) {
		
		for(int i = 0; i < A.length - 1; i++) {
			for(int j = i+1; j < A.length; j++) {
				if(A[i] == A[j])
					return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6, 6};
		boolean result = containsDuplicate(A);
		
		System.out.println(result);
	}
}
