class Solution {
    public boolean canJump(int[] nums) {
        
        //video ref: https://www.youtube.com/watch?v=Zb4eRjuPHbM
        
        int lastGoodIndex = nums.length-1;
        
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=lastGoodIndex){
                lastGoodIndex=i;
            }
        }
        
        return lastGoodIndex==0;
    }
}