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
    public boolean isCousins(TreeNode root, int x, int y) {

        //we will do bfs and keep on storing the numbers in a hashset. Then check if both are there or not.
        //this skips only one condition that is if both belongs to same parent or not. That we can check explicitly while putting into the queue.
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        while(!que.isEmpty()){
            int numberOfNodesInCurrentLevel = que.size();
            HashSet<Integer> currentLevelValues = new HashSet<>();

            for(int i=0;i<numberOfNodesInCurrentLevel;i++){
                TreeNode poppedNode = que.poll();
                currentLevelValues.add(poppedNode.val);

                if(poppedNode.left!=null && poppedNode.right!=null){
                    if((poppedNode.left.val==x && poppedNode.right.val==y) || (poppedNode.left.val==y && poppedNode.right.val==x)) //check if they are children of same parent.
                        return false;
                }

                if(poppedNode.left!=null) que.add(poppedNode.left);
                if(poppedNode.right!=null) que.add(poppedNode.right);

            }

            if(currentLevelValues.contains(x) && currentLevelValues.contains(y)) return true; //check if both belongs to the same level.
            currentLevelValues.clear();
        }
        return false;

    }
}
