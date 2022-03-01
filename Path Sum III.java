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
    //Optimized approach. Here using Prefix sum approach.
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer,Integer> sumToCountOfSuchPathMap = new HashMap<>();
        sumToCountOfSuchPathMap.put(0,1);
        return findPaths(root, sumToCountOfSuchPathMap, targetSum, 0);
    }

    public int findPaths(TreeNode root, HashMap<Integer,Integer> map, int targetSum, int currSum){
        int count=0;
        if(root==null)
            return count;

        currSum+=root.val;
        count+=map.getOrDefault(currSum-targetSum,0);
        //put the currentSum into the map.
        map.put(currSum, map.getOrDefault(currSum,0)+1);

        //check left and right sub-tree path's.
        count+=findPaths(root.left, map, targetSum, currSum) + findPaths(root.right, map, targetSum, currSum);

        //evict the current into the map.
        map.put(currSum, map.getOrDefault(currSum,0)-1);
        return count;

    }

}
