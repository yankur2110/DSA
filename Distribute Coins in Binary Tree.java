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

    int moves=0; //global moves variable.
    public int distributeCoins(TreeNode root) {
        getBalanceCoinsUsingDFS(root); //get the balance ++ count the moves.
        return moves;
    }

    public int getBalanceCoinsUsingDFS(TreeNode node){
        if(node==null) return 0; //if null, it's meaningless.

        int left = getBalanceCoinsUsingDFS(node.left);
        int right = getBalanceCoinsUsingDFS(node.right);

        moves+=Math.abs(left) + Math.abs(right); //each extra/required node has to come up to this node, hence add all these.

        return node.val+left+right-1; //total balance remaining after internal balancing.
    }
}
