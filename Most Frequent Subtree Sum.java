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

    Map<Integer, Integer> sumToFreqMap = new HashMap<Integer, Integer>();
    int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> resultList = new ArrayList<>();
        for (int currSum : sumToFreqMap.keySet()) {
            if (sumToFreqMap.get(currSum) == maxFreq) //if the currentSum has max frequency, add to result.
                resultList.add(currSum);
        }
        return resultList.stream().mapToInt(i->i).toArray();
    }

    //calculate sum and it's frequency ++ keep track of max frequency.
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int sumForCurrentRoot = dfs(root.left) + dfs(root.right) + root.val;

        //increment the frequency for that sum.
        sumToFreqMap.put(sumForCurrentRoot, sumToFreqMap.getOrDefault(sumForCurrentRoot, 0) + 1);

        //max
        maxFreq = Math.max(maxFreq, sumToFreqMap.get(sumForCurrentRoot));
        return sumForCurrentRoot;
    }
}
