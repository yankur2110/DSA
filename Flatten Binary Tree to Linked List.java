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
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        //flatten the right subtree first.. and accordingly set the prev.
        flatten(root.right);
        //flatten the left subtree then.. This would have already used the prev set in  above. It will then set the new prev i.e., left's root.
        flatten(root.left);

        //set the current treenode's right and left.
        root.right = prev;
        root.left = null;

        //set the current processed root as prev.
        prev = root;
    }
}
