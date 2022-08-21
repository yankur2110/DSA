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
    int count=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, new HashSet<Integer>());
        return count;
    }

    public void dfs(TreeNode root, HashSet<Integer> set){
        if(root==null) return;

        int rootVal = root.val;

        //add the current element to hashset.
        if(set.contains(rootVal)){
            set.remove(rootVal);
        }else{
            set.add(rootVal);
        }

        //check if it's a leaf node.
        if(root.left==null && root.right==null && set.size()<=1){
            count++;
        }

        dfs(root.left,set);
        dfs(root.right,set);

        //remove the current element from hashset after you're done with processing of the current node and it's childs.
        if(set.contains(rootVal)){
            set.remove(rootVal);
        }else{
            set.add(rootVal);
        }
    }
}
