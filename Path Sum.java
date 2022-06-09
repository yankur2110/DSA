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
    public boolean hasPathSum(TreeNode root, int requiredSum) {
        if(root==null) return false;

        //if it's the leaf node and it's sum is equal to the requiredSum.
        if(root.left == null && root.right == null && requiredSum-root.val==0) return true;

        //if not, then check both sides of tree, now requiredSum would be subtracted by current node val.
        return (hasPathSum(root.left, requiredSum-root.val) || hasPathSum(root.right, requiredSum-root.val));
    }

}
