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
    HashSet<Integer> hashSet = new HashSet<>();
    List<TreeNode> resultList = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i : to_delete)  hashSet.add(i);
        helper(root, null, true);
        return resultList;
    }

    public void helper(TreeNode root, TreeNode parent, boolean isLeft){
        if(root==null) return;
        if(parent==null && !hashSet.contains(root.val)) resultList.add(root);

        if(hashSet.contains(root.val)){
            if(isLeft && parent!=null){
                parent.left=null;
            }else if(!isLeft && parent!=null) {
                parent.right=null;
            }
            parent=null;
        }else{
            parent=root;
        }
        helper(root.left, parent,true);
        helper(root.right, parent,false);
    }
}
