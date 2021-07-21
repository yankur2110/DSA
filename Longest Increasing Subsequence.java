class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        int maxLIS=0;
        for(int i=nums.length-1; i>=0;i--){
            
            int max_of_next_subsequences=0;
            for(int j=i+1;j<=nums.length-1;j++){
                if(nums[j]>nums[i])
                 max_of_next_subsequences = Math.max(max_of_next_subsequences,dp[j]);
            }
            
            dp[i]=Math.max(1,1+max_of_next_subsequences);
            maxLIS=Math.max(maxLIS,dp[i]);
            
        }
        
        return maxLIS;
    }
}
