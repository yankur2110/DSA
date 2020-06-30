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

//print nth level and push (n+1)th level in queue.
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(root==null)
            return resultList;
        
        Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
        levelQueue.add(root);
        
        while(levelQueue.isEmpty()==false){
            List<Integer> levelNodeList = new ArrayList<Integer>(); 
            
            int size = levelQueue.size();
            
            for(int i=0;i<size;i++){
                
                TreeNode current = levelQueue.remove();
                levelNodeList.add(current.val);                
                if(current.left!=null)
                    levelQueue.add(current.left);
            
                if(current.right!=null)
                    levelQueue.add(current.right);
            }
            
            resultList.add(levelNodeList);
            
        }
        
        return resultList;
        
    }
}