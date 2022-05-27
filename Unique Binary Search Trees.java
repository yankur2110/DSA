class Solution {
    public int numTrees(int n) {
        int[] uniqueBstDpArray = new int[n+1]; //DP Array.
        uniqueBstDpArray[0]=uniqueBstDpArray[1]=1; // with 0 or 1 node, only 1 Unique BST is possible, base case.

        // the main logic of this problem is UBST is dependent on number of nodes and not the node values.

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
              uniqueBstDpArray[i]+= uniqueBstDpArray[j]*uniqueBstDpArray[i-j-1]; //different unique BST with 1,2....n as root -> Summations of all these would give the total unique BST of n.
            }
        }

        return uniqueBstDpArray[n]; //nth index would have the result.

    }
}
