class Solution {

    class Result{
        int maxLeafValueInThisSubtree; //max leaf_value for a node (including).
        int requiredMinCostTillThisNode; //min cost for node (including).

        Result(int max_leaf, int reqd_cost){
            this.maxLeafValueInThisSubtree=max_leaf;
            this.requiredMinCostTillThisNode=reqd_cost;
        }
    }
    Result[][] dp; //Object to store max_leaf_value and min_cost.

    public int mctFromLeafValues(int[] arr) {
        dp = new Result[arr.length][arr.length];
        return recursiveFunc(arr, 0, arr.length-1).requiredMinCostTillThisNode; //recursive function.
    }

    public Result recursiveFunc(int[] arr, int startIndex, int endIndex){
        if(dp[startIndex][endIndex]!=null) return dp[startIndex][endIndex]; //memoization. The main piece of code.

        if(startIndex==endIndex){ //if start and end index are equal that means it's a leaf node.
            return new Result(arr[startIndex], 0);
        }

        Result min = null;
        for(int i=startIndex;i<endIndex;i++){ //try different binary tree combination i.e., taking startIndex to i as leftsubtree leaves and i+1 to end as right subtree leaves.
            Result left_subtree = recursiveFunc(arr, startIndex,i);
            Result right_subtree = recursiveFunc(arr, i+1,endIndex);

            Result current_node_as_root = new Result(Math.max(left_subtree.maxLeafValueInThisSubtree, right_subtree.maxLeafValueInThisSubtree), left_subtree.requiredMinCostTillThisNode + right_subtree.requiredMinCostTillThisNode + left_subtree.maxLeafValueInThisSubtree * right_subtree.maxLeafValueInThisSubtree); //result of current node from it's children.

            if(min==null){
                min = current_node_as_root;
            }else if(min.requiredMinCostTillThisNode > current_node_as_root.requiredMinCostTillThisNode){
                min = current_node_as_root;
            } //take the best combination in result.

        }

        dp[startIndex][endIndex]=min; //store the result for next computations.
        return min; //return the mincost.


    }
}
