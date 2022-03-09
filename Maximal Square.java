class Solution {
    public int maximalSquare(char[][] matrix) {
        int largestLength =0;
        int dp[][] = new int[matrix.length+1][matrix[0].length+1];

        for(int i=1;i<=matrix.length;i++)
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j - 1]); //core logic: min of (top, left and diagonal(Top-Left)) covers all the area of length min+1, if current 1 is included... with current 1 as the bottom right element of that square.
                    largestLength = Math.max(largestLength, dp[i][j]);
                }
            }
        return largestLength*largestLength;
    }
}
