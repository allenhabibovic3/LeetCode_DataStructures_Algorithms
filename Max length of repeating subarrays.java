class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        
        int[][] D = new int[m][n];
        int max = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i] == B[j]){
                    if(i == 0 || j == 0)
                        D[i][j] = 1;
                    else
                        D[i][j] = 1 + D[i-1][j-1];
                    max = Math.max(max, D[i][j]);
                }
            }
        }
        
        return max;
    }
}
