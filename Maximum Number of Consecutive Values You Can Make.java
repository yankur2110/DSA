class Solution {
    public int getMaximumConsecutive(int[] nums) {
        Arrays.sort(nums);
        int result=1; //the next number we want to make.

        for(int i: nums){
            if(i>result) break; //we would have result-1.. summation possible before considering this element. If the current number is >result, then it won't be possible to make result.
            result+=i;
        }

        return result; //apparently we won't be be able to make result hence total number of numbers at that time would be 0....result-1 i.e., total of result.
    }
}
