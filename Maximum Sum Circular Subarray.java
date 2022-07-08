class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int totalSum=0;
        int currMax=0, currMin=0;

        //there are two cases, either the max subarray would lie somewhere in middle (just simple kadane's) OR it will lie at ends. For second case, we will find the minSubarray sum. Now the maxSubarray sum would be Max of case 1, total- case2 min.
        //we have to take care of all min elements because as per question we cannot return 0.

        for(int i : nums){
            totalSum+=i;
            currMax+=i;
            currMin+=i;

            maxSum=Math.max(currMax, maxSum);
            if(currMax<0){
                currMax=0;
            }

            minSum=Math.min(currMin, minSum);
            if(currMin>0){
                currMin=0;
            }

        }

        if(maxSum<0) return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }
}
