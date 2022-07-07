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
    List<TreeNode> inorderListOfNodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return balancedTreeFromInorderList(0, inorderListOfNodes.size()-1);
    }

    public TreeNode balancedTreeFromInorderList(int start, int end){
        if(start>end) return null;
        int mid=(start+end)/2;

        TreeNode node = new TreeNode(inorderListOfNodes.get(mid).val);
        node.left=balancedTreeFromInorderList(start, mid-1);
        node.right=balancedTreeFromInorderList(mid+1, end);
        return node;

    }

    public void inorder(TreeNode node){
        if(node==null) return;
        inorder(node.left);
        inorderListOfNodes.add(node);
        inorder(node.right);
    }
}
