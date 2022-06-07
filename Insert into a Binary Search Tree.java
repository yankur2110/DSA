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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }

        //traverse the BST normally, once you find null.. insert your val there.
        if(val<root.val){
            if(root.left==null){
                root.left = new TreeNode(val);
            }else{
                root.left = insertIntoBST(root.left, val);
            }
        }else{
            if(root.right==null){
                root.right = new TreeNode(val);
            }else{
                root.right = insertIntoBST(root.right, val);
            }
        }

        return root;
    }
}
