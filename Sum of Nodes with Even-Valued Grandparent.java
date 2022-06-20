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
    int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }

    //simple dfs, if root's value is even. Then add it's children values to sum.
    public void dfs(TreeNode root){
        if(root==null) return;
        if(root.val%2==0){
            addGrandChildrenValToSum(root);
        }

        dfs(root.left);
        dfs(root.right);
    }

    //adding the value with null check.
    public void addGrandChildrenValToSum(TreeNode root){
        if(root.left!=null){
            if(root.left.left!=null) sum+=root.left.left.val;
            if(root.left.right!=null) sum+=root.left.right.val;
        }
        if(root.right!=null){
            if(root.right.left!=null) sum+=root.right.left.val;
            if(root.right.right!=null) sum+=root.right.right.val;
        }
    }
}
