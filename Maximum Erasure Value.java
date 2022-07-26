class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int currSubArraySum=0;
        int maxSum = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int start=0, end=0 ; end<nums.length; end++){

            if(set.contains(nums[end])){
                while(nums[start]!=nums[end]){
                    currSubArraySum-=nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                if(nums[start]==nums[end]){
                    currSubArraySum-=nums[start];
                    start++;
                }
            }

            set.add(nums[end]);
            currSubArraySum+=nums[end];

            maxSum=Math.max(currSubArraySum, maxSum);
        }

        return maxSum;
    }
}
