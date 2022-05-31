class Solution {
    int count=0;
    public int countSubstrings(String s) {

        for(int i=0;i<s.length();i++){
            splitFromMiddle(i,i,s); //consider odd length palindrome with middle element as i'th element.
            splitFromMiddle(i,i+1,s); //consider even length palindrome with (i)th and (i+1)th element as middle.
        }
        return count;
    }

    public void splitFromMiddle(int startIndex, int endIndex, String s){

        while(startIndex>=0 && endIndex<s.length()){ //validation check.

            if(s.charAt(startIndex)==s.charAt(endIndex)){ //if characters are same, increment count.
                count++;
            }else{ //if characters are not same, no need to check further.
                break;
            }

            startIndex--; //check for next possible palindromic substring.
            endIndex++;
        }
    }
}
