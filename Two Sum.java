class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] random= new int[2];
        for(int i=0 ; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if((nums[i] + nums[j]) == target ){
                    random[0]=i;
                    random[1]=j;
                    return random;
                }
            }
        }
        return random;
    }
}