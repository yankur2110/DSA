class Solution {
    public int maxRepOpt1(String text) {
        int[] freqArray = new int[26];
        int n = text.length();
        //keep count of frequency of each character in the text.
        for(int i=0;i<n;i++){
            freqArray[text.charAt(i)-'a']++;
        }

        //core logic starts here:
        int i=0;
        int max=0;
        while(i<n){
            //checking the max potential length for current element present at index i.
            char charInConsideration = text.charAt(i);

            int k=i;
            while(k<n && text.charAt(k)==charInConsideration){
                k++;
            }

            int j=k+1;
            //after skipping the kth index element. Indirectly performing swap operation.
            while(j<n && text.charAt(j)==charInConsideration){
                j++;
            }

            //we need to make sure we haven't swapped the kth element with the character which is already included in count. If yes, then we should skip otherwise include it.
            int resForCurr = (j-i-1 == freqArray[charInConsideration-'a'])?j-i-1:j-i;

            max = Math.max(max, resForCurr);
            i=k;
        }

        return max;
    }
}
