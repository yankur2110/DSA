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
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null)
            return true;
        
        return isEqual(root.left,root.right);
        
    }
    
    public boolean isEqual(TreeNode tree1,TreeNode tree2){
        
        if(tree1==tree2)
            return true;
        if(tree1==null || tree2==null)
            return false;
        if(tree1.val!=tree2.val)
            return false;
        if(!( isEqual(tree1.left,tree2.right) )  || !( isEqual(tree1.right,tree2.left) ))
            return false;
        return true;
    }
}