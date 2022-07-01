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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode helper(int[] preorder, int pre_start, int pre_end, int[] postorder, int post_start, int post_end){
        if(pre_start==pre_end && post_start==post_end) return new TreeNode(preorder[pre_start]); //if only one node is left.
        if(pre_start>pre_end || post_start>post_end) return null; //break condition, since in this case construction of tree is not possible.

        TreeNode currRoot = new TreeNode(preorder[pre_start]); //construct the currentRoot.

        int nextRootIndexInPost = findIndexInPost(postorder, preorder[pre_start+1]);
        int leftSubtreeNodes = nextRootIndexInPost-post_start+1; //find nodes in left subtree, accordingly we can construct left and right subtree.

        currRoot.left = helper(preorder, pre_start+1, pre_start+leftSubtreeNodes, postorder, post_start, post_start+leftSubtreeNodes-1); //leftSubtree construction call.

        currRoot.right = helper(preorder, pre_start+leftSubtreeNodes+1, pre_end, postorder, post_start+leftSubtreeNodes, post_end-1); //rightSubtree construction call.

        return currRoot;
    }

    public int findIndexInPost(int[] postorder, int val){ //check the index of root to determine the no. of nodes in left subtree.
        for(int i=0;i<postorder.length;i++){
            if(postorder[i]==val) return i;
        }
        return 0;
    }
}
