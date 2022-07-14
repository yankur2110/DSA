class Solution {
    public int findLongestChain(int[][] pairs) {
        //it's exactly clone problem of longest increasing subsequence P300.
        int n = pairs.length, res=1;
        //sort the pairs based on end values.
        Arrays.sort(pairs, (a,b) -> a[1]-b[1]);
        int[] dp = new int[n];

        //here's the logic.
        //we start to fill the dp array from end. To fill dp[i] we will find the LIS i.e.., dp[j] where j>i.
        //add the current elemnt to it i.e., dp[i]= 1+ max. Return the res.
        for(int i=n-1;i>=0;i--){
            int max=0;
            for(int j=i+1;j<n;j++){
                if(pairs[i][1]<pairs[j][0]){
                    max=Math.max(max, dp[j]);
                }
            }
            dp[i]=Math.max(1,1+max);
            res=Math.max(res,dp[i]);
        }

        return res;
    }
}
