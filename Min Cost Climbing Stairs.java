class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int top = cost.length;

        int[] dp = new int[top+1]; //dp[i] represents the minCost required to reach i.
        dp[0]=0; dp[1]=0;

        for(int i=2;i<=top;i++){
            dp[i] = Math.min(cost[i-2] + dp[i-2], cost[i-1]+dp[i-1]);
        }

        return dp[top];

    }
}
