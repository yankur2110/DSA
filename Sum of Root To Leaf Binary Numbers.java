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
    String str= ""; //global string to represent different binary representation.
    Integer resultSum=0; //final result;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root); //do the dfs traversal.
        return resultSum;
    }

    public void dfs(TreeNode root){
        if(root==null) return;

        str+=String.valueOf(root.val); //add the number.

        if(root.left==null && root.right==null){ //if it's a leaf, get the decimal value and add to result.
            resultSum+=getDecimalValue(str);
        }
        dfs(root.left);
        dfs(root.right);
        str=str.substring(0,str.length()-1); //remove the current value once it is we have got all representation of childs.

    }

    public int getDecimalValue(String str){ //method to compute decimal value from binary representation.
        int power=0;
        int sum=0;

        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='1')
                sum+=Math.pow(2,power);
            power++;
        }
        return sum;
    }
}
