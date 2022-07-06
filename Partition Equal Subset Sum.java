class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int i:nums) totalSum+=i;
        if(totalSum%2!=0) return false; //if total sum is odd, it is not possible to divide into two subsets.

        int reqdSum=totalSum/2;

        //create a dp array where dp[i][j] represents if it is possible to form the sum j with first i elements of array.
        boolean[][] dp = new boolean[nums.length+1][reqdSum+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], false);
        }

        //since 0 can be formed with any number of elements.
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];

                //if we can form the sum 'j' without the current element or with current element i.e,. nums[i-1].
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }


        //return the bottom right element of array.
        return dp[dp.length-1][dp[0].length-1];

    }
}
