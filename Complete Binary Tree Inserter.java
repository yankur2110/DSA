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
class CBTInserter {
    Queue<TreeNode> insertionQue; //this queue keeps the order in which insertion of new node has to done to follow complete binary tree properties.
    TreeNode root;

    public CBTInserter(TreeNode root) {
        insertionQue = new LinkedList<>();
        this.root = root;
        populateQueue(); //populate the insertionQue.
    }

    private void populateQueue(){
        //do the bfs to populate the queue.
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        //overall we have taken two queues, first one(que) to just do the bfs traversal and put into second queue(insertionQueue.. the main one) if any child i.e., left or right is null.
        while(!que.isEmpty()){
            int size = que.size();

            for(int i=0;i<size;i++){
                TreeNode polledNode = que.poll();

                if(polledNode.left==null || polledNode.right==null){
                    insertionQue.add(polledNode);
                }

                if(polledNode.left!=null) que.add(polledNode.left);
                if(polledNode.right!=null) que.add(polledNode.right);

            }
        }
    }

    public int insert(int val) {
        TreeNode topNode = insertionQue.peek();
        if(topNode.left==null){
            topNode.left = new TreeNode(val);
            insertionQue.add(topNode.left);
        }else{
            topNode.right = new TreeNode(val);
            insertionQue.add(topNode.right);
            insertionQue.poll();
        }
        return topNode.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
