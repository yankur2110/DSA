class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        return findCombination(nums, target);
    }

    //like normal combinations problem I solved as if backtracking was the only solution however this is not the case with this. Backtracking gave TLE.
    //here we are doing repeated calculations because we are asking for same target value from the whole array multiple times hence DP can be used..

    public int findCombination(int[] nums, int target){
        if(target<0)
            return 0;

        if(dp[target]!=-1){
            return dp[target];
        }

        int res=0;
        for(int i=0;i<nums.length;i++){
            res+=findCombination(nums,target-nums[i]);
        }

        dp[target]=res;
        return res;
    }
}
