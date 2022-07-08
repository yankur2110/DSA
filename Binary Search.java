class Solution {
    public int search(int[] nums, int target) {
        int start=0, end=nums.length-1, mid=-1;
        while(start<=end){
            mid=start+(end-start)/2;

            if(nums[mid]==target)
                return mid;

            if(target<nums[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return (nums[mid]==target)?mid:-1;
    }
}
