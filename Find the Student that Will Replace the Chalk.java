class Solution {
    public int chalkReplacer(int[] chalkArray, int k) {
        long chalksRequiredInOneIteration = 0;
        for(int chalkRequired : chalkArray){
            chalksRequiredInOneIteration+=chalkRequired;
        }
        k%=chalksRequiredInOneIteration;

        for(int i=0;i<chalkArray.length;i++){
            int chalkRequired = chalkArray[i];
            if(k-chalkRequired<0){
                return i;
            }

            k-=chalkRequired;
        }

        return 0;
    }
}
