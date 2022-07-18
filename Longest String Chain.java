class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)->(a.length()-b.length()));
        int[] dp = new int[words.length]; //max chainlength ending at index 'i' of words array.
        int result = 0;

        //solve it like subsequence problem.
        for(int i=0;i<words.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                //find the previous words with which current word can form the chain..
                if(isIFormingChainWithJ(words[i], words[j])){
                    max=Math.max(max, dp[j]); //take the max of it.
                }
            }
            dp[i]= max+1; //add max previous chain to current.
            result=Math.max(result,dp[i]); //update the global max.
        }

        return result;
    }

    public boolean isIFormingChainWithJ(String word1, String word0){
        if(word1.length()!=(word0.length()+1)) return false;

        int diffChar = 0;
        int j=0;
        for(int i=0;i<word1.length();i++){
            if(diffChar==0 && j==word0.length() && i==word1.length()-1) return true;

            if(word1.charAt(i)==word0.charAt(j)){
                j++;
                continue;
            }else{
                diffChar++;
            }

            if(diffChar>1){
                return false;
            }
        }

        return diffChar==1?true:false;
    }

}
