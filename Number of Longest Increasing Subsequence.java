class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n]; //dp array for LIS length.
        //additional array required to count the number of LIS occurred till that index.
        int[] countLIS = new int[n];
        dp[0]=1; countLIS[0]=1;
        int count=1, longestSubSequenceLength=1;

        for(int i=1;i<n;i++){
            int max=0;
            int maxCount=1; //used to populate countLIS.
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]==max){
                        maxCount+=countLIS[j];
                    }else if(dp[j]>max){
                        maxCount=countLIS[j];
                    }

                    max=Math.max(max, dp[j]);
                }
            }
            dp[i]=Math.max(1,1+max); //set the LIS length ending at current index 'i'.
            countLIS[i]=maxCount;

            if(dp[i]>longestSubSequenceLength){//if LIS is ending at current index 'i' then update the LIS length found so far and also the count.
                longestSubSequenceLength=dp[i];
                count=maxCount;
            }else if(dp[i]==longestSubSequenceLength){
                count+=maxCount;
            }
        }

        return count;
    }
}
