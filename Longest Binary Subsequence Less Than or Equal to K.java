class Solution {
    public int longestSubsequence(String s, int k) {

        //logic is we will take all 0's and then check for every 1's from RHS.
        int numOfOnes=0;
        int numOfZeroes=0;
        int sum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')
                numOfZeroes++;
        }

        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                sum+=Math.pow(2,s.length()-1-i);
                if(sum<=k)
                    numOfOnes++;
                else
                    break;
            }
        }

        return numOfOnes+numOfZeroes;
    }
}
