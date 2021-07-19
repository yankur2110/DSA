class Solution {
    public void moveZeroes(int[] nums) {
        
        int countZeroes = 0;
        int actualNonZeroIndex =0;
        
        for(int i: nums){
            if(i==0)
                countZeroes++;
            else
                nums[actualNonZeroIndex++]=i;
        }
        
        for(int i=nums.length-countZeroes; i<nums.length;i++){
            nums[i]=0;
        }
    }
}
