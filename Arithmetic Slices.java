class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length]; //dp[i] represents the number of arithmetic subarrays that ends at i.
        int sum=0;

        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1; //dp[i-1]+1 because one element is added. Not that intuitive though.
                //all previous one will be extended by 1 ++ one more will be created, hence adding 1.
            }else{
                dp[i]=0; //if it's not a arithmetic subarray
            }

            sum+=dp[i];
        }
        return sum;
    }
}
