class Solution {
    int max=0;
    public int maxConsecutiveAnswers(String answerKey, int k) {
        maxSubstringWithAtMostKChar(answerKey, k, 'T');
        maxSubstringWithAtMostKChar(answerKey, k, 'F');
        return max;
    }

    //sliding window function.
    public void maxSubstringWithAtMostKChar(String s, int k, char ch){
        int start=0, end=0;
        int violations=0;

        //in each while loop we are getting the valid window size ending at end.
        while(end<s.length()){
            char currChar = s.charAt(end);
            if(currChar==ch){ //expand the window.
                violations++;
            }

            while(violations>k){ //shrink the window, incase current window is invalid.
                if(s.charAt(start)==ch){
                    violations--;
                }
                start++;
            }

            max=Math.max(max, end-start+1); //compare the current window with max window so far.
            end++;
        }
    }
}
