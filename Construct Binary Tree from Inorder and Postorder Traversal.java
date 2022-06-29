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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        //break condition.
        if(inStart>inEnd || postStart>postEnd) return null;

        //create the new root.
        TreeNode root = new TreeNode(postorder[postEnd]);

        //find index of root node in inorder.
        int indexOrRootInInorder = getIndexOfValInInorder(postorder[postEnd], inorder);
        //left side in inorder (after index) represents the left subtree.
        int numberOfLeftSubtreeNodes = indexOrRootInInorder-inStart;

        //construct the left subtree.
        root.left= buildTreeHelper(inorder, inStart, inStart+numberOfLeftSubtreeNodes-1, postorder, postStart, postStart+numberOfLeftSubtreeNodes-1);

        //construct the right subtree.
        root.right= buildTreeHelper(inorder, indexOrRootInInorder+1, inEnd, postorder, postStart+numberOfLeftSubtreeNodes, postEnd-1);

        //return the root.
        return root;
    }

    //method to find the index of a val in inorder.
    public int getIndexOfValInInorder(int val, int[] inorder){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return 0;
    }

}
