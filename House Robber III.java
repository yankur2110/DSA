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
    public int rob(TreeNode root) {

        //maxAmountWithRootNode and maxAmountWithoutRootNode if rob starts at root.
        int[] maxAmountThatCanBeRobbedStartingFromNode = maxAmtWithORWithout(root);

        //max of those two would be the answer.
        return Math.max(maxAmountThatCanBeRobbedStartingFromNode[0], maxAmountThatCanBeRobbedStartingFromNode[1]);
    }

    //this gives the maxAmount that can be robbed (with and without root robbed) if robbery starts at root.
    public int[] maxAmtWithORWithout(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }

        //Result from left and right.
        int[] leftResult = maxAmtWithORWithout(root.left);
        int[] rightResult = maxAmtWithORWithout(root.right);

        //Result for current node.
        // case: including root.
        int[] result = new int[2]; //first index means including, second means excluding.
        result[0] = root.val + leftResult[1] + rightResult[1];

        // case: excluding root.
        result[1] = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]); //this is important as if we have excluded the current root, we are free to rob left and/or right.
        //it's totally our choice, so we will take the maximum from each side.

        return result;

    }
}
