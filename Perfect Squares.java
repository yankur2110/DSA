class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        
        if(n<=3)
            return n;
        
        for(int i=1;i<=n;i++){
            dp[i]=i;
            
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i], 1+dp[i-j*j]);
            }
            
        }
        
        return dp[n];
    }
}
