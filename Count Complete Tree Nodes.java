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
    public int countNodes(TreeNode root) {
        //find leftmost leaf depth and rightmost leaf depth.
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        //if equal, then it's a fully complete binary tree. Total nodes would be 2^h-1.
        if(leftHeight==rightHeight){
            return (int)Math.pow(2,leftHeight)-1;
        }else{ //if not, check again for left and right subtree + include the node as well.
            return countNodes(root.left)+countNodes(root.right)+1;
        }

    }

    //function to find left-most leaf depth.
    public int findLeftHeight(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.left;
        }
        return height;
    }

    //function to find right-most leaf depth.
    public int findRightHeight(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.right;
        }
        return height;
    }
}
