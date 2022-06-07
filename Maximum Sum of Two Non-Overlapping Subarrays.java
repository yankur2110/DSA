class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        //passing swapped lengths to cover all cases.
        return Math.max(returnMaxSumWithRespectiveLengthsOnRespectiveSide(nums, firstLen, secondLen),
                       returnMaxSumWithRespectiveLengthsOnRespectiveSide(nums, secondLen, firstLen));
    }

    //this method basically creates 2 dp's (dp1 and dp2) that stores the maximum sum of subarray of length left and right respectively from left and right side respectively including the current element.
    //then in the end, we check the maximum sum possible this way.
    public int returnMaxSumWithRespectiveLengthsOnRespectiveSide(int[] nums, int left, int right){
        int len=nums.length;
        int[] dp1 = new int[len], dp2 = new int[len];
        int maxTillNow=0; //these two variables are used to fill dp's (like the Kadane's algorithm.)
        int currentSum=0;

        //set the maxSubArray sum of length left from left side.
        for(int i=0;i<len;i++){
            if(i>left-1){
                currentSum-=nums[i-left];
            }
            currentSum+=nums[i];
            maxTillNow = Math.max(maxTillNow, currentSum);

            //insert the values into dp1.
            if(i>=left-1){
                dp1[i]=maxTillNow;
            }
        }

        //set the maxSubArray sum of length right from right side.
        maxTillNow=0; currentSum=0;
        for(int i=len-1;i>=0;i--){
            if(i<len-right){
                currentSum-=nums[i+right];
            }
            currentSum+=nums[i];
            maxTillNow = Math.max(maxTillNow, currentSum);

            //insert the values into dp2.
            if(i<=len-right){
                dp2[i]=maxTillNow;
            }
        }

        maxTillNow=0; //using the same variable.
        //result.
        for(int i=0;i<len-1;i++){
            maxTillNow = Math.max(dp1[i]+dp2[i+1], maxTillNow);
        }
        return maxTillNow;


    }
}
