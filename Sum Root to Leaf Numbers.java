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
    int sum; //result sum.
    String str=""; //string that represents each path from root to leaf.
    public int sumNumbers(TreeNode root) {
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode root){ // a simple dfs.
        if(root==null) return;
        str+=String.valueOf(root.val);

        if(root.left==null && root.right==null){ //if it's a leaf get the number added to sum.
            addIntFromStringToSum(str);
        }

        dfs(root.left);
        dfs(root.right);
        str=str.substring(0,str.length()-1); //remove the element from the string once it is included in the sum.

    }

    public void addIntFromStringToSum(String num){ //function to convert string to integer number.
        sum+=Integer.parseInt(num);
    }
}
