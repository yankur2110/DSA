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
    HashSet<Integer> numberSet = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    public boolean dfs(TreeNode node, int target){
        if(node==null) return false;

        if(numberSet.contains(target-node.val)) return true; //check if hashSet contains target-currElement already.
        numberSet.add(node.val); //add the number to hashSet.
        return dfs(node.left, target) || dfs(node.right, target); //check if either of the left/right subtree has the desired number.
    }
}
