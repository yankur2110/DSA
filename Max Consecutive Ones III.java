class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxWindow=0, start =0; //start pointer and max variable to check the max length.

        for(int end=0;end<nums.length;end++){ //note we are incrementing the end pointer every time.
            if(nums[end]==0){ //if it's a 0 at end, decrement the k.
                k--;
            }
            if(k<0){ //here observe that it's in if only.. because we are doing end++ in each iteration. So, we check everytime if k<0 and incrementing the start everytime. So, that we doesn't get non existing greater window.
                if(nums[start]==0) k++;
                start++;
            }
            maxWindow = Math.max(maxWindow, (end-start+1)); //increment maxWindow size accordingly.
        }

        return maxWindow;
    }
}
