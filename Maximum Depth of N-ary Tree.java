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
    public int maxDepth(Node root) {
        if(root==null) return 0;

        int depth=0;
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            depth++;
            int size=que.size();

            for(int i=0;i<size;i++){
                Node polledNode = que.poll();

                for(Node node : polledNode.children){
                    que.add(node);
                }
            }
        }
        return depth;

    }
}
