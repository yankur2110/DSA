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
    int count=0;
    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);
        return count;
    }

    //get all leaf nodes distances of a node.
    //check distance between left and right for every leaf.
    public List<Integer> helper(TreeNode root, int distance){

        if(root==null){
            return new ArrayList<>();
        }
        if(root.left==null && root.right==null){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }

        List<Integer> left = helper(root.left, distance);
        List<Integer> right = helper(root.right, distance);

        incrementBy1(left);
        incrementBy1(right);

        for(int i: left){
            for(int j: right){
                if(i+j<=distance) count++;
            }
        }

        for(int j : right){
            left.add(j);
        }

        return left;

    }

    public void incrementBy1(List<Integer> list){
        for(int i=0;i<list.size();i++){
            list.set(i, list.get(i)+1);
        }
    }
}
