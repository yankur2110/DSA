class Solution {
    public int maxProduct(int[] nums) {
         int n=nums.length;
        int max=nums[0], currMax=nums[0], currMin=nums[0];        
        for(int i=1;i<n;i++){
            if(nums[i]>0){
                currMax=Math.max(nums[i],currMax*nums[i]);
                currMin=Math.min(nums[i],currMin*nums[i]);
            }else{
                int temp=currMax;
                currMax=Math.max(nums[i],currMin*nums[i]);
                currMin=Math.min(nums[i],temp*nums[i]);
            }
            
            max=Math.max(max,currMax);
        }
        
        
        return max;
    }
}