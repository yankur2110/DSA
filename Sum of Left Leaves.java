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
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;

        helper(root.left, true);
        helper(root.right, false);
        return sum;
    }

    public void helper(TreeNode node, boolean isLeft){
        if(node==null) return;
        if(node.left==null && node.right==null && isLeft){
            sum+=node.val;
            return;
        }

        helper(node.left, true);
        helper(node.right, false);
    }
}
