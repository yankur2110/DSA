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
    //Iterative approach using stack.
    List<Integer> resultList = new ArrayList<Integer>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if(root==null){
            return new ArrayList<Integer>();
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        s.push(current);
        current = current.left;
        
        while(s.isEmpty()==false || current!=null){
            if(current == null){
                current = s.pop();
                resultList.add(current.val);
                current = current.right;
                continue;
            }
            s.push(current);
            current=current.left;
        }
        
        return resultList;
    }
}