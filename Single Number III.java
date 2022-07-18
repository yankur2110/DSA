class Solution {
    public int[] singleNumber(int[] nums) {
        int XORofReqdNos = 0;
        //find the XOR of two numbers which are not in pairs.
        for(int i : nums){
            XORofReqdNos=XORofReqdNos^i;
        }

        //find their first 'ON' bit. This 'ON' bit represents that the digit are different in both the numbers.
        //hence we will form groups based on these bits. Group1: elements which have that ON. Group2: elements which have that OFF.
        //take XOR of all elements of both these groups. We will get required two nos.
        int firstONbit = (XORofReqdNos)&(-XORofReqdNos);
        int[] result = new int[2];

        for(int i : nums){
            if((firstONbit & i)==0){
                result[0]^=i;
            }else{
                result[1]^=i;
            }
        }

        return result;

    }
}
