class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //there is only one way to traverse the first row and first column because we can only move right or down..therefore initialize first col and first row with 1.
        
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=1;
        }
        
        for(int i=1;i<dp.length;i++){
            
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
            
        }
        
        return dp[dp.length-1][dp[0].length-1];
    
        
    }
}