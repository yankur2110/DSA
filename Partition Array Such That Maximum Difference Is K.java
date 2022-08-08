class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        //greedily try to keep the distance minimum.

        int start=0, end=1;
        int result=0;

        while(start<nums.length){
            result++;

            if(start==nums.length-1){
                break;
            }

            end=start+1;
            int min=nums[start];
            int max=nums[end];

            while((max-min)<=k && end<nums.length){
                end++;
                if(end<nums.length)
                    max=nums[end];
            }
            start=end;
        }

        return result;
    }
}
