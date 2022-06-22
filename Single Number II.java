class Solution {
    public int singleNumber(int[] nums) {
        //answer variable.
        int ans=0;

        //check each bit position of all numbers one by one.
        for(int i=0;i<32;i++){

            //count the onBitsAtPosition 'i'. If it's equal to 1 when taking mod with 3, then it means for the odd number, that bit is on.
            int onBitsAtPositionI=0;

            //counting 'on' bits at that position.
            for(int j=0;j<nums.length;j++){
                if((nums[j]>>i & 1) ==1) //right shifting 'i' times so that i'th bit of nums[j] comes at LSB.
                    onBitsAtPositionI++;
            }

            onBitsAtPositionI%=3;

            //if it's on, make this position on in our answer.
            if(onBitsAtPositionI!=0){
                ans|= (onBitsAtPositionI<<i); //left shift the onBitsAtPosition 'i' times, so that it comes at the right place... then take OR with ans.
            }

        }

        //return answer.
        return ans;
    }
}
