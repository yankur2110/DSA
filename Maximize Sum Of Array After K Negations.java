class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums); //sort the array.
        int sum=0;
        //if k>0 and nums[i] is <0, simply negative.
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0 && k>0){
                nums[i]=-nums[i];
                k--;
            }
        }

        //find sum.
        for(int i: nums) sum+=i;

        //if no K is remaining, return sum.
        if(k%2!=1) return sum;
        else{ //if 1 negation has to be done. Then find the min element and negative it. Also decrement the min element twice because it was already included in the sum.
            Arrays.sort(nums);
            int min = nums[0];
            sum-=2*min;
            return sum;
        }

    }


}
