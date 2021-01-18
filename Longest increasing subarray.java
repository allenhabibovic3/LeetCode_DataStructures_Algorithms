package chapter07;

public class Graph {
	//    int arr[] = {5, 6, 3, 5, 7, 8, 9, 1, 2}; 
	public static int longestIncreasingSubarray(int[] arr) {
		int n = arr.length;
		
		int len = 1;
		int max = 1;
		
		for(int i = 0; i < n-1; i++) {
			if(arr[i+1] > arr[i]) {
				len++;
				if(len > max)
					max = len;
			}else {
				len = 1;
			}
		}
		
		return max;
		
	}
	
	public static void main(String[] args) {
	    int arr[] = {5, 6, 3, 5, 7, 8, 9, 1, 2,3,4,5,6,7,8}; 
	    
	    int result = longestIncreasingSubarray(arr);
	    System.out.println(result);
	}
}
