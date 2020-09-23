class Solution {
    /* we will use dynamic programming */
    //https://www.youtube.com/watch?v=iWenZCZEBIA&t=391s&ab_channel=FisherCoder
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        
        /*Note that dp[i]=true means, it's possible to make the substring(0,i+1) using given words*/
        return dp[n];
    }
}