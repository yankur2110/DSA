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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> resulNodeList = new LinkedList<>();

    preorder(root, new HashMap<>(), resulNodeList); //represent the tree and put into map.. to check if it's a duplicate or not.

    return resulNodeList;
}

public String preorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
    if (cur == null) return "#";  //represent null childs of leaf node as '#',so that a single traversal representation can denote a structure of tree.

    String serializedPreOrder =  cur.val + preorder(cur.left, map, res)+ "," + preorder(cur.right, map, res) + "," +  cur.val ; //Preorder representation with current node as root.

    map.put(serializedPreOrder, map.getOrDefault(serializedPreOrder, 0) + 1); //put this representation into map. Increment the count to 2 if already exists otherwise put 1.

    if (map.get(serializedPreOrder) == 2) res.add(cur); //if count is 2, it means it's duplicate -> add to resultNodeList.

    return serializedPreOrder; //return serialized preorder representation to caller.
}
}
