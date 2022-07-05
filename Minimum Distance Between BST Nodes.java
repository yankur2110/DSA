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
    int min=Integer.MAX_VALUE, prev=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        //inorder traversal.
        if(root==null) return 0;
        minDiffInBST(root.left);

        //for the current node, check the difference with prev node val.
        min = Math.min(min, Math.abs(root.val-prev));

        //update the current as prev.
        prev=root.val;

        minDiffInBST(root.right);

        //return the global min.
        return min;
    }
}
