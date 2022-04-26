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
    List<List<Integer>> resultList = new ArrayList<>(); //global result.
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return resultList;
        List<Integer> currentList = new ArrayList<>();
        DFS(root, targetSum, currentList);
        return resultList;
    }

    public void DFS(TreeNode root, int targetSum, List<Integer> currentList){
        if(root==null) return;

        if(root.left==null && root.right==null && root.val==targetSum){
            List<Integer> targetList = new ArrayList<>(currentList); //saving a new ArrayList.
            targetList.add(root.val);
            resultList.add(targetList);
        }

        currentList.add(root.val); //add the current node value for next paths.
        DFS(root.left, targetSum-root.val, currentList);
        DFS(root.right, targetSum-root.val, currentList);
        currentList.remove(currentList.size()-1); //remove the current node value once traversed.


    }
}
