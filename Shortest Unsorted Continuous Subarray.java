class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int end=-1, start=0, max=nums[0], min=nums[n-1];

        //find the end.
        for(int i=1;i<n;i++){
            if(nums[i]>=max){
                max=nums[i];
            }else{
                end=i;
            }
        }

        //find the start.
        for(int i=n-1;i>=0;i--){
            if(nums[i]<=min){
                min=nums[i];
            }else{
                start=i;
            }
        }

        return end-start+1;
    }
}
