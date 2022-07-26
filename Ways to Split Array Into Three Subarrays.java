class Solution {
    public int waysToSplit(int[] nums) {
        long count=0;
        int mod= (int)1e9+7; //for mod.
        int n=nums.length;

        for(int i=1;i<n;i++){ //prefix sum array.
            nums[i]=nums[i-1]+nums[i];
        }

        for(int i=1;i<n-1;i++){
            int leftMost = binarySearch(nums, i, nums[i-1], true); //find leftMost index which will can be a pointer to divide mid and right subarray.
            int rightMost = binarySearch(nums, i, nums[i-1], false); //find rightMost index which can be a pointer to divide mid and right subarray.

            if(leftMost==-1 || rightMost==-1){  //if no one is breaking the condition.
                continue;
            }

            count= (count + (rightMost-leftMost+1))%mod; //all indexes in this range can divide the subarray (mid and right) .. and can form good subarray with subarray till 'i' i.e., left one.. Hence add them all.
        }

        return (int)count%mod;
    }


    public int binarySearch(int[] nums, int start, int leftSum, boolean findLeftMost){
        int res=-1;
        int left=start, right = nums.length-2;

        while(left<=right){

            int mid = left+(right-left)/2;
            int midSum = nums[mid]-leftSum;
            int rightSum = nums[nums.length-1]-nums[mid];

            if(leftSum<=midSum && midSum<=rightSum){
                res=mid;
                if(findLeftMost){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else if(leftSum>midSum){ //if till mid leftSum > midSum. Then we have to search for the required index in mid+1 to right for sure.
                left=mid+1;
            }else{ //likewise if leftSum<midSum, we have to search for the required index in left to mid-1 for sure.
                right=mid-1;
            }

        }

        return res;
    }
}
