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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int prev=1;

        while(!que.isEmpty()){
            int size=que.size();

            for(int i=0;i<size;i++){
                TreeNode polledNode = que.poll();

                //logic begins here.
                //if the current node has value but previous was a leaf then return false.
                if(polledNode.val>0 && prev<0)
                    return false;

                //in case current node is leaf, assign prev as -1 and continue.
                if(polledNode.val==-1 ){
                    prev=-1;
                    continue;
                }

                //if polledNode is not a leaf actually, put it's childs to the que. In case of leaf put add a new node with value -1.
                if(polledNode.left==null){
                    que.add(new TreeNode(-1));
                }else{
                    que.add(polledNode.left);
                }
                if(polledNode.right==null){
                    que.add(new TreeNode(-1));
                }else{
                    que.add(polledNode.right);
                }
                prev=polledNode.val;
                //logic ends here.

            }
        }

        return true;
    }
}
