class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum=nums[0]+nums[1]+nums[2], potentialClosestSum=0; //randomly chosen closestSum.
        Arrays.sort(nums); //sort the array.
        for(int i = 0; i<nums.length; i++){
            int start = i+1;
            int end=nums.length-1;

            while (start<end){
                potentialClosestSum = nums[i]+nums[start]+nums[end];

                if(potentialClosestSum>target){ //if sum is greater than target, decrement end.
                    end--;;
                }else{ //if sum is smaller than target, increment start. i.e., our aim is to go close to target anyhow.
                    start++;
                }

                if(Math.abs(potentialClosestSum - target)<Math.abs(closestSum - target)) //check if current sum is more close to the target when compared to closestSum we have assumed/got so far.
                    closestSum= potentialClosestSum;
            }
        }

        return closestSum;

    }
}
