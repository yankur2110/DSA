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
    int greaterSum=0;

    public TreeNode convertBST(TreeNode root) {
        //Instead of inorder traversal we will do reverse i.e., right -> root -> left. While traversing, we will update the value in tree as well.
        if(root==null) return null;
        convertBST(root.right);
        root.val+=greaterSum;
        greaterSum=root.val;
        convertBST(root.left);

        return root;
    }
}
