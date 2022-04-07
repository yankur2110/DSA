class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=0, end = nums.length-1;
        while(start<end){
            int mid=(start+end)/2; //find the mid element.

            if(mid%2==1) mid--; //IT'S THE MOST CRUCIAL PART. if mid is odd, it means that it is pointing to the right element of pair. However we want left element of pair.

            if (nums[mid] != nums[mid + 1]) end = mid; //if mid and mid+1 are not equal that means left part has the element.
            else start = mid + 2; //otherwise right part has the element.
        }

        return nums[start]; //in the end start would contain the single element.
    }
}
