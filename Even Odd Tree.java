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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level=-1, prev=-1;
        boolean incExpected=true;


        while(!que.isEmpty()){
            level++;
            //in each level we are checking if number of nodes in that level are correct or not.
            //if there's childs are following the increasing/decreasing pattern or not.
            int size=que.size();
            if(level%2==0){
                incExpected=true;
                prev=Integer.MIN_VALUE;
            }else{
                incExpected=false;
                prev=Integer.MAX_VALUE;
            }

            Stack<Integer> stackForCurrentLevel = new Stack<>();

            for(int i=0;i<size;i++){
                TreeNode polledNode = que.poll();
                int val = polledNode.val;

                if(level%2==0 && val%2==0 || level%2!=0 && val%2!=0) return false;

                if(incExpected){
                    if(val<=prev) return false;
                    prev=val;
                }else{
                    if(val>=prev) return false;
                    prev=val;
                }

                if(polledNode.left!=null){
                    que.add(polledNode.left);
                }
                if(polledNode.right!=null){
                    que.add(polledNode.right);
                }
            }
        }

        return true;


    }
}
