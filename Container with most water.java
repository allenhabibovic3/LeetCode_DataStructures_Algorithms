public class NQueens {
	//find the max area between two array indices
	//water container problem
	
	public static int maxArea(int[] A, int n) {
		int area = 0;
		int l = 0;
		int r = n - 1;
		
		while(l < r) {
			area = Math.max(area, Math.min(A[l], A[r]) * (r-l));
			
			if(A[l] < A[r]) {
				l++;
			}else {
				r--;
			}
		}
		
		return area;
	}
	
	
	public static void main(String[] args) {
		int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};
     
        int len1 = 4;
        System.out.print( maxArea(a, len1)+"\n" );
     
        int len2 = 5;
        System.out.print( maxArea(b, len2) );
	}
}
