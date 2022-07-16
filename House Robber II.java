class Solution {
    int[] dp;
    //this problem is similar to house robber I, where the robber is allowed to rob from all houses.
    //since robber is not allowed to rob first and last house together it simply means either he can rob from 1 to last house or 0 to n-1 house.
    //just implement the same.
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        dp=new int[nums.length];
        return Math.max(rob0(nums), rob1(nums));
    }

    public int rob0(int[] nums){
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length-1;i++){
           dp[i]=Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[nums.length-2];
    }

    public int rob1(int[] nums){
        dp[0]=0;
        dp[1]=nums[1];
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
