class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int[] merged = new int[m+n];
        
        int i = 0, j = 0, k = 0;
        
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]){
                merged[k++] = nums1[i++];
            }else {
                merged[k++] = nums2[j++];
            }
        }
        
        while(i < m){
            merged[k++] = nums1[i++];
        }
        
        while(j < n){
            merged[k++] = nums2[j++];
        }
        
        double mid = 0.0;
        
        if(merged.length % 2 == 1) {
             mid = (merged[(int)Math.floor(merged.length/2)]);   
        }else {
            mid = (double)(merged[(merged.length)/2] + merged[(merged.length/2)-1])/2;
        }
        return mid;
    }
}
