class Solution {
    public int search(int[] nums, int target) {
        
        //first we need to find the pivot element using modified binary search.
        //then we will have two sorted arrays, perform normal binary search on them.
        
        if(nums==null || nums.length==0)
            return -1;
        
        int left = 0;
        int index = 0;
        int right = nums.length-1;
        
        while(left<right){
           int mid=(left+right)/2;
            
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        System.out.println(left+" "+right);
        
        if(target>=nums[left] && target<=nums[nums.length-1])
            index=binarySearch(nums,target,left,nums.length-1);
        else
            index=binarySearch(nums,target,0,left-1);
        
        return index;
        
    }
    
    public int binarySearch(int[] nums,int target,int left,int right){
        
        System.out.println(left+" "+right);
        
         if(left>right){
            return -1;
        }
        
        int mid=(left+right)/2;
        
        if(nums[mid]==target){
            return mid;
        }
        
        if(target<nums[mid]){
            return binarySearch(nums,target,left,mid-1);
            
        }
        else{
            return binarySearch(nums,target,mid+1,right);
        }
    }
}