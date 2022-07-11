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
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root==null) return resultList;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            List<Integer> currentLevelList = new ArrayList<>();
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode polledNode = que.poll();
                if(polledNode.left!=null) que.add(polledNode.left);
                if(polledNode.right!=null) que.add(polledNode.right);
                currentLevelList.add(polledNode.val);
            }
            resultList.add(0,currentLevelList); //this is the important part here.
        }

        return resultList;
    }
}
