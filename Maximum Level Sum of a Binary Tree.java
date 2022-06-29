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
    public int maxLevelSum(TreeNode root) {
        //just do a simple bfs.
        int level=0;
        int minReqdLevel=0;
        int sum = Integer.MIN_VALUE;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            level++;
            int size = que.size();
            int levelSum=0;

            for(int i=0;i<size;i++){
                TreeNode polledNode = que.poll();
                levelSum+=polledNode.val;

                if(polledNode.left!=null){
                    que.add(polledNode.left);
                }

                if(polledNode.right!=null){
                    que.add(polledNode.right);
                }
            }


            if(levelSum>sum){
                minReqdLevel=level;
                sum = levelSum;
            }

        }

        return minReqdLevel;
    }
}
