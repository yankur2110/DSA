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
    List<Integer> resultList = new ArrayList<>();
    int top = Integer.MIN_VALUE;
    int count=0, maxCount = -1;;
    public int[] findMode(TreeNode root) {
        helper(root);
        return resultList.stream().mapToInt(i->i).toArray();
    }

    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        //the main part.
        count= (top==root.val)?count+1:1;

        if (count == maxCount) {
            resultList.add(root.val);
        } else if (count > maxCount) {
            resultList.clear();
            resultList.add(root.val);
            maxCount = count;
        }
        top=root.val;
        //main part ends here.
        helper(root.right);
    }
}
