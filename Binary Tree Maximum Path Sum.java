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
    
    //ref: https://www.youtube.com/watch?v=mOdetMWwtoI&t=187s
    
    int max_path_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        helper(root);
        return max_path_sum;
    }
    
    public int helper(TreeNode root){
        
        if(root==null)
            return 0;
        
        int left = Math.max(0,helper(root.left)); //incase left subtree is giving negative value is max.
        int right = Math.max(0,helper(root.right));
        
        max_path_sum = Math.max(max_path_sum, (left+right+root.val)); // incase our root is the orignal root whose max_path_sum is to be found, in that case maximum will left left_max+right_max+val or already found max.
        
        return Math.max(right,left)+root.val;
    }
}