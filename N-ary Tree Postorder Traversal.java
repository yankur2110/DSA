/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> resultList = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root==null) return resultList;
        for(Node node: root.children){
            postorder(node);
        }
        resultList.add(root.val);
        return resultList;
    }
}
