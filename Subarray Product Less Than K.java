class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count=0, prod=1;
        for(int i=0,j=0;j<nums.length;j++){
            prod*=nums[j]; //since 'j' is included in the window, it has to be multiplied.
            while(i<=j && prod>=k){
                prod/=nums[i++]; //since 'i' is exluded from window, it has to be divided. We are shrinking the window with i++.
                //note that the next window would start from this 'i' only. Because if current window's product is <k then next window's product might be <k. Also if current window's product >=k, then i should be incremented.
            }

            //number of subarrays that can be formed in this window is equal to size of window.
            count+=(j-i+1);
        }

        return count;
    }
}
