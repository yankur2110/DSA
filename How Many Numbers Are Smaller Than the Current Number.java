class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        for(int i:nums){
            freq[i]++;
        }

        int prefixSum=0;
        int[] prefixSumArr = new int[101];

        for(int i=0;i<=100;i++){
            prefixSumArr[i]=prefixSum;
            prefixSum+=freq[i];

        }

        for(int i=0;i<nums.length;i++){
            nums[i]=prefixSumArr[nums[i]];
        }

        return nums;
    }
}
