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

    private boolean result=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        height(root);
        return result;

    }

    public int height(TreeNode root){
        if(root==null) return 0;

        int leftHeight=height(root.left)+1;
        int rightHeight=height(root.right)+1;

        //in this problem main issue was of sending back the boolean where at each node we have to compare the height of both left and right subtree, for which our function needs to return int.
        //so we have a way around, we have taken a global variable which will store false if the height difference of left and right subtree is >1. In the end we will return this result variable only.
        if(Math.abs(leftHeight-rightHeight)>1){
            result=false;
        }

        return Math.max(leftHeight,rightHeight);


    }


}
