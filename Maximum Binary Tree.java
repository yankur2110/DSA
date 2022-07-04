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
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaxBinaryTreeHelper(nums, 0, nums.length-1);
    }

    public TreeNode constructMaxBinaryTreeHelper(int[] nums, int start, int end){
        if(start>end || start>=nums.length) return null;
        int maxIndex = findMaxIndex(nums, start, end);

        TreeNode currRoot = new TreeNode(nums[maxIndex]);
        currRoot.left = constructMaxBinaryTreeHelper(nums, start, maxIndex-1);
        currRoot.right = constructMaxBinaryTreeHelper(nums, maxIndex+1, end);
        return currRoot;

    }

    public int findMaxIndex(int[] nums, int start, int end){
        int maxValue=-1, maxIndex=-1;

        for(int i=start;i<=end;i++){
            if(maxValue<nums[i]){
                maxValue=nums[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}
