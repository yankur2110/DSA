class Solution {
    //custom treeNode class.
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int totalNodes=0;
        long score=0L;
    }

    public int countHighestScoreNodes(int[] parents) {
        int totNodes = parents.length;
        TreeNode[] treeNodes = new TreeNode[totNodes];

        for(int i=0;i<totNodes;i++){
            treeNodes[i]=new TreeNode();
        }

        //first we need to construct the tree.
        for(int i=1;i<totNodes;i++){
            if(treeNodes[parents[i]].left==null)
                treeNodes[parents[i]].left=treeNodes[i];
            else
                treeNodes[parents[i]].right=treeNodes[i];
        }

        //set totalNodes in each node (including the node and it's childs)l
        dfsCountNodes(treeNodes[0]);

        long maxScore =0L;
        //set score for each node.
        for(int i=0;i<totNodes;i++){
            TreeNode currNode = treeNodes[i];

            int leftCount = (currNode.left==null)?0:currNode.left.totalNodes;
            int rightCount = (currNode.right==null)?0:currNode.right.totalNodes;
            int topNodes = totNodes-leftCount-rightCount-1;

            long product=1;
            if(leftCount>0) product*=leftCount;
            if(rightCount>0) product*=rightCount;
            if(topNodes>0) product*=topNodes;

            currNode.score=product;
            maxScore = Math.max(product, maxScore);
        }

        int ans=0;
        //check which all nodes have maxScore's.
        for(int i=0;i<totNodes;i++){
            if(treeNodes[i].score==maxScore)
                ans++;
        }

        return ans;
    }

    public int dfsCountNodes(TreeNode root){
        if(root==null) return 0;
        root.totalNodes = dfsCountNodes(root.left)+dfsCountNodes(root.right)+1;
        return root.totalNodes;
    }
}
