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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode node = new TreeNode();

        if(root1==null && root2==null) return null;
        int sum=0;
        if(root1!=null && root2==null){
            node.val=root1.val;
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
            return node;
        }
        if(root1==null && root2!=null){
            node.val=root2.val;
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
            return node;
        }


        node.val=root1.val + root2.val;
        node.left=mergeTrees(root1.left, root2.left);
        node.right=mergeTrees(root1.right, root2.right);

        return node;
    }
}
