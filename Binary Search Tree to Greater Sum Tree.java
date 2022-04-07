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

    //first solution, here I am first calculating the sum of all the nodes -> then doing the inorder traversal and adding the 'totalSum-NumbersSmaller'+currentVal.
    int sum=0, index=0, currSum=0;
    List<Integer> inorderValues = new ArrayList<>();
    public TreeNode bstToGst(TreeNode root) {
        findSum(root);
        updateRoot(root);
        return root;
    }

    public void updateRoot(TreeNode root){
        if(root==null) return;
        updateRoot(root.left);
        currSum+=inorderValues.get(index++);
        root.val+=sum-currSum;
        updateRoot(root.right);
    }

    public void findSum(TreeNode root){
        if(root==null) return;
        findSum(root.left);
        inorderValues.add(root.val);
        sum+=root.val;
        findSum(root.right);
    }

    //efficient way would to be to do the reverse of inorder... it will give you the elements in descending order. Eventhough time complexity is same, code would be less bulky in this case.


}
