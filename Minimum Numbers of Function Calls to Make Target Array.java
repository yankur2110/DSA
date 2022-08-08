class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        int maxDivideOp=0;
        int temp=0;

        for(int i=0;i<nums.length; i++){
            int num=nums[i];
            temp=0;
            while(num>0){
                if(num%2!=0){
                    num--;
                    count++;
                }else{
                    num=num/2;
                    temp++;
                }
            }
            maxDivideOp=Math.max(maxDivideOp, temp);
        }

        return count+maxDivideOp;
    }
}
