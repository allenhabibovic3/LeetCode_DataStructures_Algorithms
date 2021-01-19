class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isFound = false;
        int[] row = new int[matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++) {
            int low = 0, high = matrix[0].length - 1;
            while(low <= high) {
                int mid = low + (high-low) / 2;
                
                if(matrix[i][mid] == target){
                    return true;
                }else if(target < matrix[i][mid]){
                    high = mid-1;
                }else{
                    low = mid + 1;
                }
            }
        }
        
        return isFound;
    }
}
