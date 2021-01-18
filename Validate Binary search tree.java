/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.ArrayList;
class Solution {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        helper(root, nums);
        Integer[] arr = new Integer[nums.size()];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = nums.get(i);
        }
        
        for(int i = 0; i < arr.length-1;i++) {
            if(arr[i] >= arr[i+1]){
                return false;
            }
        }
        
        return true;
    }
    
    public void helper(TreeNode root, ArrayList<Integer> nums) {
        if(root!=null) {
            helper(root.left, nums);
            nums.add(root.val);
            helper(root.right, nums);
        }
    }
}
