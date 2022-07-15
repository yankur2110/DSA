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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null ) return root;
        return containsOne(root)?root: null;
    }

    public boolean containsOne(TreeNode root){
        if(root==null) return false;
        if(root.val==0 && root.left==null && root.right==null) return false;
        if(root.val==1 && root.left==null && root.right==null) return true;

        boolean leftContainsOne = containsOne(root.left);
        boolean rightContainsOne = containsOne(root.right);
        if(!leftContainsOne){
            root.left=null;
        }
         if(!rightContainsOne){
            root.right=null;
        }

        return leftContainsOne || rightContainsOne || (root.val==1);
    }
}
