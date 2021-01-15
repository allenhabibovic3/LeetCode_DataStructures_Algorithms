public class NQueens {

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/
	
	public static int findTrappedWaterVolume(int[] heights) {
		
		int result = 0;
		int n = heights.length;
		
		for(int i = 1; i < n - 1; i++) {
			int left = heights[i];
			
			for(int j = 0; j < i; j++) {
				left = Math.max(left, heights[j]);
			}
			
			int right = heights[i];
			
			for(int j = i + 1; j < n; j++) {
				right = Math.max(right, heights[j]);
			}
			
			result += Math.min(left, right) - heights[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
		int volume = findTrappedWaterVolume(heights);
		
		System.out.println(volume);
	}
}
