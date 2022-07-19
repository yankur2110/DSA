class Solution {
    public boolean checkPossibility(int[] nums) {
        int count=0;

        for(int i=1;i<nums.length && count<=1;i++){
            if(nums[i]<nums[i-1]){

                //if current element is greater than the nums[i-2]. It means nums[i-1] is the culprit. Assign nums[i] to it.
                if(i-2<0 || nums[i] >= nums[i-2])
                    nums[i-1] = nums[i];
                else  //otherwise nums[i] is the culprit. Assign nums[i]=nums[i-1].
                    nums[i] = nums[i-1];

                count++;
            }
        }

        return count<=1;
    }
}
