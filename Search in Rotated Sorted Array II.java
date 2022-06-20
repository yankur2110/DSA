class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }

            //If we know for sure left side is sorted or right side is unsorted
            if (nums[start] < nums[mid] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            //If we know for sure right side is sorted or left side is unsorted
            else if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            //If above two conditions are false it means all are equal, mid, left and right but not equal to the target. In this case just shrink the boundary. Hence shrink the boundary, we can do start++ as well.
            else {
                end--;
            }
        }
        return false;


    }
}
