class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] prod = new int[n];
        
        for(int i = 0; i < n; i++) {
            int idx = i;
            int curr = 1;
            for(int j = 0; j < n; j++) {
                if(j == idx){
                    continue;
                }
                curr *= nums[j];
            }
            prod[idx] = curr;
        }
        
        return prod;
    }
}
