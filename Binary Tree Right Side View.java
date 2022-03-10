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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        if(root==null) return resultList;

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        
        while(!bfsQueue.isEmpty()){

            int size = bfsQueue.size();

            for(int i=0;i<size;i++){
                TreeNode poppedNode = bfsQueue.poll();
                if(i==size-1) resultList.add(poppedNode.val);

                if(poppedNode.left!=null)
                    bfsQueue.offer(poppedNode.left);
                if(poppedNode.right!=null)
                    bfsQueue.offer(poppedNode.right);
            }
        }

        return resultList;
    }
}
