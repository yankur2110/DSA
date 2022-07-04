class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int start=0;
        int end=nums.length-1;

        while(start<end){
            while(start<nums.length && nums[start]%2==0){
                start++;
            }

            while(end>=0 && nums[end]%2!=0){
                end--;
            }

            if(start<nums.length && end>=0 && start<end){
                int temp = nums[start];
                nums[start]=nums[end];
                nums[end] = temp;
                start++;;
                end--;
            }

        }

        return nums;
    }
}
