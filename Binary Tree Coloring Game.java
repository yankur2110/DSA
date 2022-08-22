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
    int leftOfX, rightOfX;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        int max = Math.max(n-leftOfX-rightOfX-1, Math.max(leftOfX, rightOfX));
        return max>n/2;
    }

    public int count(TreeNode root, int x){
        if(root==null) return 0;

        int left = count(root.left,x);
        int right = count(root.right,x);

        if(root.val==x){
            leftOfX=left;
            rightOfX=right;
        }

        return left+right+1;
    }
}
