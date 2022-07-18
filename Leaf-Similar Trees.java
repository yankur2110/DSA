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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leaf1 = new StringBuilder();
        StringBuilder leaf2 = new StringBuilder();
        formLeaf(root1, leaf1);
        formLeaf(root2, leaf2);
        return leaf1.toString().equals(leaf2.toString());
    }

    public void formLeaf(TreeNode root, StringBuilder str){
        if(root==null) return;
        if(root.left==null && root.right==null){
            str.append(root.val+" "); return;
        }

        formLeaf(root.left, str);
        formLeaf(root.right, str);
    }
}
