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

//The main logic is whether we can include the root or not.
class Solution {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root){
        if(root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max=Math.max(max, left+right);
        return Math.max(left,right)+1;
    }

}
