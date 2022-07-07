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
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {

        Queue<Node> que = new LinkedList<>();
        if(root==null) return resultList;
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> currentLevelList = new ArrayList<>();

            for(int i=0;i<size;i++){
                Node polledNode = que.poll();
                currentLevelList.add(polledNode.val);

                for(Node child : polledNode.children){

                    que.add(child);
                }
            }

            resultList.add(currentLevelList);
        }


        return resultList;
    }
}
