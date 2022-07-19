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
    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1,n);
    }

    public List<TreeNode> generateTreesHelper(int start, int end){
        List<TreeNode> list = new ArrayList<>();

        //base condition.
        if(start>end){
            list.add(null);
            return list;
        }

        for(int i=start;i<=end;i++){

            //consider each element as root and generate all possible combination of BST's.
            //for that we take 'i' as a root and make recursive call for left and right childs.
            //note: here we are doing repetitive calculations which can be optimized with dp. That we can try some time later.
            List<TreeNode> leftList = generateTreesHelper(start,i-1);
            List<TreeNode> rightList = generateTreesHelper(i+1,end);

            //generate all trees possible.
            for( TreeNode left : leftList){
                for(TreeNode right: rightList){
                    TreeNode root = new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    list.add(root);
                }
            }
        }

        return list;
    }
}
