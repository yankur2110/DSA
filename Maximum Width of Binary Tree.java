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
    public int widthOfBinaryTree(TreeNode root) {

        //idea is to modify TreeNode's values to their respective index in that level. That we can get using the logic... if a node's index is n in current level then in next level it's child's indexes would be 2*n, (2*n)+1 for left and right child respectively.
        LinkedList<TreeNode> que = new LinkedList<>();
        int maxWidth = 0;

        root.val=0;
        que.offer(root);

        //do the bfs.
        while(!que.isEmpty()){

            int nodesAtCurrentLevel = que.size();
            maxWidth = Math.max(maxWidth, que.peekLast().val - que.peekFirst().val + 1); //find the maxWidth of current level.

            for(int i=0;i<nodesAtCurrentLevel;i++){
                TreeNode polledNode = que.poll();

                if(polledNode.left!=null){
                    polledNode.left.val=2*polledNode.val; //while pushing update the node values of left-child.
                    que.offer(polledNode.left);
                }

                if(polledNode.right!=null){
                    polledNode.right.val=2*polledNode.val + 1; //while pushing update the node values of left-child.
                    que.offer(polledNode.right);
                }
            }
        }

        return maxWidth; //return maxWidth.
    }
}
