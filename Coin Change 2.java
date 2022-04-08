class Solution {
    public int change(int amount, int[] coins) {
       int[][] dp = new int[coins.length+1][amount+1]; //create dp array with each coin added in each row.. i.e., [0], [1], [1,2], [1,2,5].
        //column would contain amount from 0 to amount.

        //DP[i][j] represents the number of combinations to make sum 'j', using first 'i' coins.

        dp[0][0] = 1; //0 can be formed with 0 coins. Hence DP[0][0]=1.

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1; //since 0 can be formed with any combination of coins. You can do this separately outside the loop as well for understanding. But this is better.

            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0); //start populating the dp. i.e., DP[i][j] would be equal to = consider we don't use this coin ++ if we use this coin.
            }
        }
        return dp[coins.length][amount]; //return the bottom right numer.
    }
}
