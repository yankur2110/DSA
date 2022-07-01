class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for(int i:arr) sum+=i;
        if(sum%3!=0) return false;
        int reqdSum=sum/3;

        int partsFound=0, currSum=0;

        for(int i: arr){
            currSum+=i;

            if(currSum==reqdSum){
                partsFound++;
                currSum=0;
            }
        }

        return partsFound>=3;
    }
}
