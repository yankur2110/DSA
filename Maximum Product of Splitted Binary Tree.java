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
    //here we have taken everything in long and later at the time of returning, we will convert it to int.
    long sum=0, maxProduct=0;
    public int maxProduct(TreeNode root) {
        //to find the total sum.
        sum = findTotalSumAndTryMaxProductDFS(root);
        //to calculate the max product.
        findTotalSumAndTryMaxProductDFS(root);

        //return the maxProduct.
        return (int)(maxProduct % (1e9 + 7));
    }

    //our this function is a type of dfs which performs two operations i.e., it is checking for the product && returning the totalSum of that tree including nodes.
    public long findTotalSumAndTryMaxProductDFS(TreeNode node){
        if(node==null) return 0;

        //sum of current subtree including the root.
        long totalSumWithNode = node.val+ findTotalSumAndTryMaxProductDFS(node.left) + findTotalSumAndTryMaxProductDFS(node.right);

        //check max product.
        maxProduct = Math.max(maxProduct, totalSumWithNode*(sum-totalSumWithNode));

        //return totalSum of this subtree.
        return totalSumWithNode;
    }
}
