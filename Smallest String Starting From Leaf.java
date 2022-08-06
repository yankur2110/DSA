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
    String result = new String();
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return result;
    }

    public void dfs(TreeNode root, StringBuilder currString){
        if(root==null) return;

        if(root.left==null && root.right==null){
            char ch = (char)(root.val + 'a');
            currString.append(ch);
            currString = currString.reverse();

            if(result.length()==0 || (currString.toString()).compareTo(result)<0){
                result=currString.toString();
            }

            currString.deleteCharAt(0);
            currString = currString.reverse();
            return;
        }
        char ch = (char)(root.val + 'a');
        currString.append(ch);
        dfs(root.left, currString);
        dfs(root.right, currString);
        currString.deleteCharAt(currString.length()-1);

    }
}
