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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left; //store because we are going to update root.left.
        root.left=invertTree(root.right); //go in depth of root.right i.e., invert that first.
        root.right=invertTree(temp); //then invert left.

        //also we have changed the nodes in above two lines.
        //just return the root.
        return root;
    }
}
