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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(root==null) return resultList;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            int max=Integer.MIN_VALUE;

            for(int i=0;i<size;i++){
                TreeNode polledNode = que.poll();
                max = Math.max(max, polledNode.val);

                if(polledNode.left!=null) que.add(polledNode.left);
                if(polledNode.right!=null) que.add(polledNode.right);

            }

            resultList.add(max);
        }


        return resultList;

    }
}
