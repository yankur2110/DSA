class Solution {
    public int numWays(String s) {
        int mod = (int)1e9+7;
        int numOfOnes = 0;
        for(char ch : s.toCharArray()){
            if(ch=='1') numOfOnes++;
        }

        int n=s.length();
        if(numOfOnes==0){
            return (int)((n-2L)*(n-1L)/2%mod);
        }

        if(numOfOnes%3!=0){
            return 0;
        }

        int countOf1Reqd = numOfOnes/3;
        int currentOneCount =0;

        long splitWaysForBlock1=0, splitWaysForBlock2=0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1') currentOneCount++;

            if(currentOneCount==countOf1Reqd){
                splitWaysForBlock1++;
            }else if(currentOneCount == 2* countOf1Reqd){
                splitWaysForBlock2++;
            }
        }

        return (int)(splitWaysForBlock1*splitWaysForBlock2%mod);

    }

}
