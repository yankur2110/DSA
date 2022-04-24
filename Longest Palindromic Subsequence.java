class Solution {
    public int longestPalindromeSubseq(String s) {
        //The problem is same of LCS, if we compare LCS of given string s and reverse of this String s.
        String revOfs = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s,revOfs);

    }

    //copied from 1143.
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        int[][] dp = new int[m+1][n+1]; //DP array.

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                char ch1 = text1.charAt(i-1), ch2 = text2.charAt(j-1); //current character in both the strings.
                dp[i][j] = (ch1==ch2)? 1+dp[i-1][j-1] : Math.max(dp[i][j-1],dp[i-1][j]);//if current characters are same then LCS would be one more than the LCS of strings when current character is not included in both strings.
                //if different, then it would be max of (don't include one char from s2, don't include one char from s1)

            }
        }

        return dp[m][n];

    }
}
