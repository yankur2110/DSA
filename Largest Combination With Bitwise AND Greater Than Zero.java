class Solution {
    public int largestCombination(int[] candidates) {
        int[] numberOfElementsWithIthONBit = new int[32];

        //check number of candidates which have i'th bit ON. This gives the number of elements which will give >0 as AND result anyhow.
        for(int i=0;i<32;i++){
            for(int num : candidates){
                if(((num>>i) & 1) ==1){
                    numberOfElementsWithIthONBit[i]++;
                }
            }
        }

        int ans=0;
        //take the max of these combinations.
        for(int i : numberOfElementsWithIthONBit){
            ans=Math.max(ans,i);
        }
        return ans;
    }
}
