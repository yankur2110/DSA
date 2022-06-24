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
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(preorder, 0, preorder.length-1, new TreeNode(preorder[0]));
    }

    //construct tree method takes root of that subarray and subarray in parameter and constructs the BST.
    public TreeNode constructTree(int[] preorder, int start, int end, TreeNode rootOfThisTree){
        if(start>=end || end>=preorder.length) return rootOfThisTree;

        int startTemp = start;
        int rootVal = rootOfThisTree.val;

        //in the array (representing a BST) first node would be the root node.. and all next nodes having values less than the root node would belong to left subtree.
        //and next all nodes would belong to right subtree.

        //so find those subtree's with this loop.
        while((start+1)<=end && rootVal>preorder[start+1]){
            start++;
        }

        if(start>startTemp)
            rootOfThisTree.left=constructTree(preorder, startTemp+1, start, new TreeNode(preorder[startTemp+1]));
        if(end>start)
            rootOfThisTree.right=constructTree(preorder, start+1, end, new TreeNode(preorder[start+1]));

        return rootOfThisTree;

    }
}
