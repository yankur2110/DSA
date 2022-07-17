class Solution {
    public int[] countBits(int n) {
        int[] resultArray = new int[n+1];
        for(int i=0;i<=n;i++){
            //shifting the current number 1 bit right would give the same number (that we have stored in the result already). So, we will add that number.. but we have lost the LSB, so we will and with 1 to check if it was 1.
            resultArray[i]=resultArray[i>>1]+(i&1);
        }
        return resultArray;
    }
}
