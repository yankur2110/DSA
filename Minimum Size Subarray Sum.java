class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minLength = Integer.MAX_VALUE;
        int start=0,end=0, currSum=0;

        //set the initial window.
        while(currSum<target && end<nums.length){
            currSum+=nums[end++];
        }
        end--;

        //keep on sliding the window as per the sum of window. If it's greater then increment start. If it's less then increment end.
        while(start<=end && end<nums.length){

            if(currSum<target){
                end++;
                if(end<nums.length){
                    currSum+=nums[end];
                }
            }

            if(currSum>=target){
                minLength=Math.min(minLength, end-start+1);
                currSum-=nums[start++];
            }
        }

        //return the minLength.
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}
