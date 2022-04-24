class Solution {
    public int findMin(int[] nums) {
        return minUsingBinarySearch(nums, 0, nums.length-1);
    }

    public int minUsingBinarySearch(int[] nums, int startIndex, int endIndex){
        if(startIndex==endIndex) return nums[endIndex]; //if only one element is remaining.
        //we don't need to check (mid+1) overflow because that can happen only if single element is there.

        int mid = (startIndex+endIndex)/2; //find the middle index.

        //if already full sorted array is given.
        if(nums[startIndex]<=nums[mid] && nums[mid]<=nums[endIndex]) return nums[startIndex];

        //if not, then the unsorted sub-array has the result.
        if(nums[startIndex]<=nums[mid]) return minUsingBinarySearch(nums, mid+1, endIndex);
        else return minUsingBinarySearch(nums,startIndex, mid);
    }
}
