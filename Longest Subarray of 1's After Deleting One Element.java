class Solution {
    public int longestSubarray(int[] nums) {
        boolean deletedFromMiddle = false;
        int max=0, i=0;
        boolean allOnes = true;

        int zeroIndex = -1;
        int len=0;

        while(i<nums.length && nums[i]==0){
            allOnes=false;
            zeroIndex=i;
            i++;
        }

        for(;i<nums.length;i++){

            if(nums[i]==1){
                len++;
                max= Math.max(max, len);
            }else{
                allOnes=false;

                if(!deletedFromMiddle){
                    zeroIndex=i;
                    deletedFromMiddle=true;
                    continue;
                }else{
                    len=i-zeroIndex-1;
                    if(len==0) deletedFromMiddle = false;
                    zeroIndex=i;
                }
            }
        }


        return allOnes?max-1:max;

    }
}
