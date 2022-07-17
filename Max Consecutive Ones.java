class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;

        for(int i : nums){
            count = (i==1)?count+1:0;
            max=Math.max(count, max);
        }

        return max;
    }
}
