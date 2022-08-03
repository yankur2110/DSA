class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];

        int pos_ind=0, neg_ind = 1;
        for(int i : nums){
            if(i>=0){
                result[pos_ind]=i;
                pos_ind+=2;
            }else{
                result[neg_ind]=i;
                neg_ind+=2;
            }
        }

        return result;

    }
}
