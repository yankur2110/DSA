class Solution {
    public int findPeakElement(int[] nums) {
        return doBinarySearch(nums,0,nums.length-1);    
    }
    
    public int doBinarySearch(int[] nums, int low, int high){
        
        if(low==high)
            return low;
        
        int mid1 = (low+high)/2;
        int mid2 = mid1+1; //because if atleast two elements are there, then mid2 will exist.
        
        if(nums[mid1]>nums[mid2])
            return doBinarySearch(nums, low, mid1);
        return doBinarySearch(nums, mid2,high);
        
    }
}